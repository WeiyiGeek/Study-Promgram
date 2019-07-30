<?php
    //#method 第一种方法
	function demo($one = "I", $two ="lOVE", $three = "You"){
		echo "$one --- $two --- $three \n";
	}
	$arr = array("Weiyi", "Hacker" , "Pragram");
	call_user_func_array("demo",array());
	echo "\n";
	call_user_func_array("demo",$arr);

    //#method 第二种方法
	function demo($num, $n) { 				         // $n = "test";
		for($i=0; $i<$num; $i++) {			         // if($n($i))
			if(call_user_func_array($n, array($i)))  // 传入回调函数test($i)与参数（采用数组的方式进行输入）
				continue;
			echo $i."<br>";
		}
	}
	function test($i) {
		if($i == strrev($i) || $i % 3 == 0 || preg_match(/3/,$i))
			return true;
		else 
			return false;
	}
	demo(50, "test");