<?php

/** 用户自定义处理session */
//在php.ini设置save_handler为user
//session_module_name('user');
//ini_set('session.auto_start',0);
//echo ini_get("session.save_handler")."<br>";
//echo session_module_name();

$sess_save_path = "E:/BaiduNetdiskDownload/Seesion/session/tmp/";  //windows路径格式 # （linux处理一样）
//注册过程，让PHP自己处理session时，找这个函数指定的几个周期来完成

//session声明周期函数
//打开
function open($save_path,$session_name)
{
    global $sess_save_path;
    $sess_save_path = $save_path;
    return true;
}

//关闭
function close()
{
    return true;
}


//读取 echo $_SESSION['username'] 
function read($sid)
{
    echo $sid;
    global $sess_save_path;
    $filename = $sess_save_path."mz_".$sid;
    return @file_get_contents($filename);

}

//写入
function write($sid, $data)
{
    global $sess_save_path;
    $filename = $sess_save_path."mz_".$sid;
    return file_put_contents($filename, $data);
}


//销毁
function destroy($sid)
{
    global $sess_save_path;
    $filename = $sess_save_path."mz_".$sid;
	return @unlink($filename);
}


//回收机制 -> 需要配置php.ini的session生存时间
//session.gc_divisor=20
//session.gc_maxlifetime=14
function gc($maxlifetime)
{
    global $sess_save_path;
	foreach(glob($sess_save_path."mz_*") as $file) {
			//只删除过期的
		if(filemtime($file)+$maxlifetime < time()) {
			unlink($file);
		}
	}
}

session_set_save_handler('open','close','read','write','destroy','gc');


?>