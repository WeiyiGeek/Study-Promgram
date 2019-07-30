<?php
/*
 *  控制指定的位置 
 */
	$arr = array("one"=>"妹子", "two"=>"峰哥", "three"=>"观众", "four"=>"小四", "5"=>"five");

	//指向第四的一个元素：Method 1
	next($arr);  //移位下一个
	next($arr);
	next($arr);
	echo "当前的位置(默认在第一个): ".key($arr)."=>".current($arr)."<br>";
	reset($arr);  //重置指针

	//指向第四的一个元素：Method 2
	end($arr);   //指向末尾指针
	prev($arr);   //移位上一个
	echo "当前的位置(默认在第一个): ".key($arr)."=>".current($arr)."<br>";
	reset($arr);
