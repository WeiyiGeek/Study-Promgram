<?php
/*
 *  超全局数组(变量), 在PHP的脚本中， 已经声明完的变量， 你可以直接就去使用即可! 变量的名子已经规定好的了
 *
 *
 *  $_SERVER
 *  $_ENV
 *  $_GET
 *  $_POST
 *  $_REQUEST
 *  $_FILES
 *  $_COOKIE
 *  $_SESSION
 *  $GLOBALS
 *
 *
 *    超   全局   数组
 *
 *
 *    1. 数组(关联数组), 就和你自己声明的数组是一样的操作方式
 *    2. 全局
 *    3. 每个预定义的数组都有自独特的能力
 *
 */
	//数组
	echo '系统服务器数组：'.count($_SERVER).'个数<br>';
	$count = 1;
	foreach($_SERVER as $key => $value){
		echo $key." ===>>>> ".$value."<br>";
		if($count > 6){
			break;
		}
		$count++;
	};

	echo "<br><br>";
	//全局 (常规数组)
	$arr = array(
		"first"=>"I",
		"secend"=>"Love",
		"Three"=>"You",
		"Four"=>"Baby"
	);
	function demo1(){
		global $arr;  //常规 函数想使用必需要进行global声明;
		foreach($arr as $key => $value){
			echo "{$key} ==>> {$value}<br>";
		}
	}
	//全局 （超全局数组）
	$_GET=array("妹子", "峰哥");
	function demo() {
		echo $_GET[0]."和".$_GET[1];
		$_GET['username']="admin";  //超能可以直接添加值;
	}

	demo1();
	echo "<br><br>";
	demo();
	echo "<pre>";
	print_r($_GET);
	echo "</pre>";
