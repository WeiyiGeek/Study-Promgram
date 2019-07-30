<?php
    /** 主函数定义 **/
    function demo($num, $n) {
		for( $i=0; $i<$num; $i++) {
			if($n($i))  		// $n = "test"; 相当于变量函数
				continue;
			echo $i."\n";
		}
	}
     /** 回调函数 **/  
	function test($i) {
		//不显示 回文数 或者 3的倍数 或者 正则表达式匹配有3的数字
		if( $i == strrev($i) || $i % 3 == 0 || preg_match('/3/',$i))
			return true;
		else 
			return false;
	}
    demo(100, "test"); //这里建议加上""对于函数名成为String,如果不加就是就是常量名称,当然也是可以的（但是执行效率比字符串常量低）