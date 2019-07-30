<?php

	//list()函数 对于常用的一维数组
	$arr = ["Weiyi", "Geek", 23, "ChongQing"];
	list($name, $job, $age, $addr) = $arr;
	echo "name : ".$name."  - job : ".$job." - age : ".$age." - address : ".$addr."<br><br>";

 	//可以通过空项来对应要存储到变量中的素组元素 (可以直接=数组对象)
	list($a, , $c) = array("Weiyi", "GEEK", "Hacker");
	echo $a." -- ".$c."<br>";


	//字符串分割存储到变量
	$str="Weiyi_Geek";
    list($name,$pro) = explode("_", $str);  //explode("分割的字符",字符串) 返回的是分割后的数组
	echo $name.' -++- '.$pro;