<?php
	//连接数据库 并且选择数据库
	$host = 'localhost';
	$user = "root";
	$pass = "123456";
	$db = "book";
	//面向对象的方法
	$link = new mysqli($host, $user, $pass, $db);

	if($link->connect_error){
		echo "失败ID：{$link->connect_errno}，失败原因：{$link->connect_error}";
		die("数据库连接失败!");
	}else{
		echo "Connect successful";
	}

	
