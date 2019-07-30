<?php
/*
 *  在函数的调用时， 在参数中传的不是一个变量或一个值， 而是一个函数， 这就是回调函数参数
 *  根据数组的字符串长度来排序
 */

	$arr = array("aaaa","aa","aaaaaaaaaa", "a", "aaa","aaaaaaaaaaaaaaaaaaaa","aaaaa","dddddddd" );
	function mycom($a, $b) {
		if(strlen($a) == strlen($b)){
			return 0;
		}
			return (strlen($a) > strlen($b)) ? 1 : -1; //字符串长度从小到大排序
	}

	print_r($arr);  //新函数 打印数组
	echo "<br/>";
	usort($arr, "mycom");
	echo '<br>';
	print_r($arr);
 
