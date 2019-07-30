<?php
/** 以 memcache 来存储 session  */
class Memsession{
    private static $mem;       //memcahce 对象
    private static $maxlifetime;  //php.ini设置的生存时间

    //开启与初始化方法
    public static function start(Memcache $mem)
    {
        //初始化私有成员
        self::$mem = $mem;
        self::$maxlifetime = ini_get('session.gc_maxlifetime');
        

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
        $data = self::$mem->get($sid);
        if(empty($data))
        {   
            return '';
        }else{
            return $data;
        }

    }

    //写入或者更新session  注意PHP7.2返回类型为bool）
    public static function write($sid,$data)
    {
        //echo self::$maxlifetime;
        //注意这里使用set而不用add(); 怕session值重复
        self::$mem->set($sid,$data,MEMCACHE_COMPRESSED,self::$maxlifetime); //自带回收机制（时间）
        return true;
    }

    //销毁
    public static function destroy($sid)
    {
       return self::$mem->delete($sid,0); //0 代表立即删除
    }

    //回收
    public static function gc($maxlifetime)
    {
       return true;  //由于memcache自带回收机制，所以不用进行回收
    }

}

//建立memcache对象与资源池
$memcache = new Memcache();
$memcache->addServer('127.0.0.1',11211);

//开启用户自定义session
Memsession::start($memcache);


