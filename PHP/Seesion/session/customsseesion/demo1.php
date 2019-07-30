<?php
/** 调用用户之定义session处理方法 */
@include_once("session.php"); //必须在开启session进行包含文件
session_start();

$_SESSION['username'] = "meizi";
$_SESSION['age'] = 18;


echo $_SESSION['username']."<br>";
print_r($_SESSION);	 

session_commit();

session_destroy();