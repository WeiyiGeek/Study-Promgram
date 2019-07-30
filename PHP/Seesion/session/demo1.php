<?php
/** session会话设置 */

//1.读取会话之后立即关闭会话存储文件 (开启会话)
session_start(array(['cookie_lifetime' => 86400,'read_and_close'  => true]));   //可以修改php.ini文件里面的session配置(注意形式)
//session_start()前面不能有任何输出,  这个函数向客户端发一个session_id保存在cookie中;
//还在服务器中创建一个和保存在客户端同名的session文件(文本) ，调度PHP的机制使用session;
echo "PHPNAME: ".session_name()."<br>";
echo "Session ID: ".session_id()."<br>";
echo "session path: ".session_save_path();

//2.在session中存储信息
$_SESSION['user'] = "admin";
$_SESSION['name'] = "管理员";
$_SESSION['info']['age'] = 18;
$_SESSION['info']['addr'] = "重庆市";

//3.获取session信息
echo "<pre>";
print_r($_SESSION);
echo "</pre>";


//4.删除session[‘值’]
$username = $_SESSION['user']; //unset($_SESSION['username']);
$_SESSION = array();              //可以删除数组中的所有内容， 即session对应的这个用户文件的内容就空了
//删除客户中cookie听sessionid
if(isset($_COOKIE[session_name()])) {
    setCookie(session_name(), "", time()-3600, "/");

}

//5.销毁session及其save文件
session_destroy();

echo "再见:{$username}";