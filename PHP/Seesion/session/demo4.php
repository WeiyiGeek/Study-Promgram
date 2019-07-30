<?php
/** session 类编写 */
class FileSession {
	private static $savepath; //参数需要一个路径
	
	//开启和初使化使用的, 参数需要一个路径
    public static function start($savepath = "E:/BaiduNetdiskDownload/Seesion/session/tmp/")
    {
		self::$savepath = $savepath; //本类静态
		// 注册过程， 让PHP自己处理session时，找这个函数指定的几个周期来完成
		// __CLASS__ 本类 -> 魔术变量
		session_set_save_handler(
			array(__CLASS__, "open"), 
			array(__CLASS__,"close"),
			array(__CLASS__, "read"), 
			array(__CLASS__, "write"),
			array(__CLASS__, "destroy"), 
            array(__CLASS__,"gc"));
		session_start();  //开启会话
		$_SESSION['flag'] = "";
		//注意前面不能有输出
		//$_SESSION['version'] = PHP_VERSION;
		//$_SESSION['handler'] = session_module_name();
     
	}

	// 开启时， session_start()
	public static function open($savePath, $sessionName) {
		return true;
	}

	//关闭
	public static function close() {
		return true;
	}

	//读取 echo $_SESSION['username'] 
	public static function read($sid) {
		$filename = self::$savepath."session_".$sid;
		return @serialize(file_get_contents($filename));  //注意这里返回为字符串
	}

	//写入 $_SESSION['username'] = "meizi";
	public static function write($sid, $data) {
        $filename = self::$savepath."session_".$sid;
        return file_put_contents($filename, $data) ? true : false;
	}

	//销毁 session_destroy() 
	public static function destroy($sid) {
		$filename = self::$savepath."session_".$sid;
		return @unlink($filename);
	}

	//回收垃圾
	public static function gc($maxlifetime) {
		foreach(glob(self::$savepath."session_*") as $file) {
			//只删除过期的（查看修改时间）
			if(filemtime($file)+$maxlifetime < time()) {
				unlink($file);
			}
		}
	}

	//验证session
	public function validateId($sessionId){
		// implements SessionUpdateTimestampHandlerInterface::validateId() -- 自PHP 7.0起可用
		// 如果会话id有效，则返回值应为true，否则为false
		// 如果返回false, php将在内部生成一个新的会话id
	}

	//更新session
	public function updateTimestamp($sessionId, $sessionData){
		// SessionUpdateTimestampHandlerInterface :: updateTimestamp($sessionId, $sessionData).-- 自PHP 7.0起可用
		// 返回值对于成功应该为true，对于失败应该为false
	}
}
	//开启用户自定义初始化方法 可以传入路径
    FileSession::start();
    
?>