<?php
	/**
	 * 	采用类class里面对象的方法 与 类静态函数
	 *		$filter = new Filter();  //new 一个类名
	 *		$filter->one();  //指向对象的方法
	*		Filter::two();   //指向类静态函数*/
	function demo($num, $n) {
		for($i=0; $i<$num; $i++) {
			if(call_user_func_array($n, array($i)))  //采用调用的用户回调函数的函数
				continue;
			echo $i."-";
		}
	}
	class Filter {
		//对象的方法
		function one($i) {
			if( $i % 2 == 0) {  //过滤到数值为2的值
				return true;
			}else{
				return false;
			}
		}
		//类静态函数（查看全局与局部变量的不同）
	    static function two($i) {
			if($i == strrev($i) || $i % 3 == 0 || preg_match('/3/',$i)) {
				return true;
			}else{
				return false;
		    }	
		}
	}
	//类中对象的方法,必须采用数组的形式进行调用
	demo(50, array(new Filter(), "one"));   //需要new一个class名
	echo "\n";
	demo(50, array("Filter", "two")); 	//特别注意类静态函数的不同
 