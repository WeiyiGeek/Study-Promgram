<?php
/** 利用 MYSQL 存储 session 类 */

class Dbsession {
    private static $uid;   //用户的uid
    private static $sid;   //用户的uid
    private static $pdo;    //传入pdo资源对象
    private static $ctime;  //修改时间
    private static $maxlifetime;  //php.ini设置的生存时间
    private static $uip;  // 用户ip
    private static $uagent;  //用户浏览器信息

    //开启与初始化方法 (传入pdo值得学习)
    public static function start(PDO $pdo)
    {
        //初始化私有成员
        self::$uid = isset($_GET['uid'])?$_GET['uid']:0;
        self::$sid = isset($_GET['uid'])?$_GET['uid']:0;
        self::$pdo = $pdo;
        self::$ctime = time();
        self::$maxlifetime = ini_get('session.gc_maxlifetime');
        self::$uip = !empty($_SERVER['HTTP_CLIENT_IP']) ? $_SERVER['HTTP_CLIENT_IP'] : (!empty($_SERVER['HTTP_X_FORWARDED_FOR']) ? $_SERVER['HTTP_X_FORWARDED_FOR'] : (!empty($_SERVER['REMOTE_ADDR']) ? $_SERVER['REMOTE_ADDR'] : ""));  
        self::$uagent = htmlspecialchars(!empty($_SERVER['HTTP_USER_AGENT'])?$_SERVER['HTTP_USER_AGENT']:'unkown');
        
        //监测IP是否合法
        if(!filter_var(self::$uip,FILTER_VALIDATE_IP))
        {
            self::$uip = 'unkown';
        }

        //注册过程 (注意顺序) __CLASS__ 本类 -> 魔术变量 (注意无‘’)
        session_set_save_handler(
            array(__CLASS__,'open'),
            array(__CLASS__,'close'),
            array(__CLASS__,'read'),
            array(__CLASS__,'write'),
            array(__CLASS__,'destroy'),
            array(__CLASS__,'gc')
        );

        //开启会话 (前面不能有输出，由于setcookie(PHPSESSSION)的设置)
        session_start();
    }

    // session_start 时候触发
    public static function open($savePath,$sessionName)
    {
        return true;
    }
    public static function close(){
        return true;
    }

    //读取session 注意PHP7.2返回类型为string）
    public static function read($sid)
    {
       $stmt = self::$pdo->prepare("select * from session where sid = ?");
       $stmt->execute(array($sid));
       $result = $stmt->fetch(PDO::FETCH_ASSOC);

		//如果还没有会话信息，返回空字符串
       if(!$result){
            return '';
        }

       //判断时间是否超时（当用户待机的时候）
        if($result['utime'] + self::$maxlifetime < self::$ctime)
        {
            self::destroy($sid);
            return '';
        }

        // 判断是否换了ip或者浏览
        if($result['uip'] != self::$uip || $result['uagent'] != self::$uagent)
        {
            self::destroy($sid);
            return '';
        }

        //如果用户发生改变（恶意修改）
        if($result['uid'] != self::$uid)
        {
            self::$sid = $result['uid'];
            setcookie(session_name(),'',time()-3600,"/");
            self::destroy($_COOKIE[session_name()]);
            return '';
        }

        return $result['sdata'];
    }

    //写入或者更新session  注意PHP7.2返回类型为bool）
    public static function write($sid,$data)
    {
        //通过sid获取已经有的数据
        $stmt = self::$pdo->prepare("select * from session where sid = ?");
        $stmt->execute(array($sid));
        $result = $stmt->fetch(PDO::FETCH_ASSOC);  //关联数组


        //判断是否存在数据（没有则添加）
        if($result)
        {
            //数据发生变化或者隔一段时间进行更新
            if($result['sdata'] != $data || $result['utime'] + 20 < time())
            {
                $stmt=self::$pdo->prepare("update session set sdata = ?, utime = ?  where sid=? ");
                $stmt->execute(array($data,self::$ctime,$sid));
            }
            echo "1";
        }else{
            //数据为空，或者uid发生改变则，不进行插入而进行销毁（且seesion id 也发生改变 使其退出登录），防止入侵渗透
            if(!empty($data) && (self::$uid != 0) && self::$sid == self::$uid)
            {
                $stmt= self::$pdo->prepare("insert into session(uid,sid,sdata,utime,uip,uagent) values(?,?,?,?,?,?)");
                $stmt->execute(array(self::$uid, $sid, $data, self::$ctime, self::$uip, self::$uagent));
            }
            echo "0";
        }

        return true;
    }

    //销毁
    public static function destroy($sid)
    {
        $stmt = self::$pdo->prepare("delete from session where sid = ?");
        return $stmt->execute(array($sid));
    }

    //回收
    public static function gc($maxlifetime)
    {
        $stmt = self::$pdo->prepare("delete from session where utime < ?");
        return $stmt->execute(array(self::$ctime-self::$maxlifetime));
    }
}

//方法1 ：
// $db = new Dbsession();
// session_set_save_handler(
//     array($db,'open'),
//     array($db,'close'),
//     array($db,'read'),
//     array($db,'write'),
//     array($db,'destroy'),
//     array($db,'gc')
// );
// session_start();

//方法二：进行初始化设置（静态方法）
Dbsession::start($link);
