<?php
/*
 *   使用for遍历数组
 *
 *   效率很高， 就是数组访问方式， 只不过通过循环去取值
 *
 *   count(数组) 获取数组的长度
 *
 */

	$arr = array("aa", "bb", "cc", "dd", "ee", "ff", "ggg", "hh");
	$arr1 = ["aa","cc","dd",1,2,3,4,5];
	$arr2 = array("aa", "bb", "cc", "dd", 5=>"ee", "ff", "ggg", "hh");

	$nums = count($arr);
	for($i=0; $i < $nums; $i++) {
		echo $arr[$i].' - ';
	}
    echo "<br><br>";
	$nums = count($arr1);
	for($i=0; $i < $nums; $i++) {
		echo $arr1[$i].' - ';
    }
    
    echo "<br><br>";
	//下面由于有关联数组所以利用count获取元素的个数，赋值给下标就导致了短板;
	$nums = 9;
	for($i=0; $i < $nums; $i++) {
		echo $arr2[$i].' - ';
	}