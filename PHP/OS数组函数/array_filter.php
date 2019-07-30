<?php
	//array_filter();案例
	$arr = array(1,2,-4,false,5,6,8,9,"",-1-2,4,null,-5-8, 0);  //数组里面可以直接计算值
	var_dump(array_filter($arr)); //直接使用该函数,回过滤掉 fasle "" NULL 等假值;
	echo '<br>';

	//采用回调函数
	function myfun($value) {
		if($value >= 0)
			return true;
		else
			return false;	
	}
	print_r(array_filter($arr, "myfun"));
	echo '<br>';

	//采用了匿名函数,并重新排了索引array_values();
	var_dump(array_values(array_filter($arr, function($value){
		return ($value % 2 == 0);  //返回 2 的倍数; 为真则返回
	})));
