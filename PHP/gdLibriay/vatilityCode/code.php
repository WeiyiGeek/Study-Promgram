<?php
//开启session
session_start();
include_once("vcode.class.php");
//构造函数
$vcode = new Vcode(80,25,4);
//将验证码放到服务器空间报错
$_SESSION['code'] = $vcode->getcode();
//将验证码输出
$vcode->showcode();

