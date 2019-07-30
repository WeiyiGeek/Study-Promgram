<?php
	/**
	 *  闭包函数
	 * 
	 */

	$var = function($a, $b, $c) {
		return $a+$b+$c;
	};   //一定要加分号结束

	echo "1+2+3 = ".$var(1,2,3);
	echo "<br>闭包函数的对象类型 ：";
	var_dump($var);

	//由于它是对象所以也能赋值给其他变量
	$func = $var;
	echo "<br/>2+2+2 = ".$func(2,2,2);
