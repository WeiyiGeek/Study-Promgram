<?php
	/**变量地址引用**/
	echo "<b style='color:red;'>变量地址引用</b><br>";
	$a=5;
	$b=&$a;
	echo "b = $b --  a = $a <br>";	//b/a输出5
    $b=7; 							//有变量b的地址绑了变量a的地址所以
	echo "b = $a -- a = $b <br>";	//a/b输出7


	/***通过unset($c)重置变量与内存地址的关联  */
	echo "<b style='color:red;'>通过unset($c)重置变量与内存的关联</b><br>";
	$c = 1024;  //当这时使用unset函数变量是不存在的 unset($c);  变量c不存在
	$c = &$b;  //当把变量B的地址给c然后使用unset函数把变量$b释放掉;  变量c是存在
	unset($b);
	if(isset($c))
	{
		echo "变量存在<br/>";
	}else{
		echo "变量不存在<br/>";
	}

	/** 变量地址的捆绑与取消  **/
	$j = 520;
	$k = &$j;   //对变量j取地址，两个变量捆绑在一起.
	$k = 5200; //将会修改K/j的值

	$i = 1024;
	$k = &$i;  //对变量i取地址,自动取消与变量j的关联
	$k = 2048;  //与变量i的地址绑定,便修改了i的值

	echo "<br/> j = $j , k = $k , i = $i<br/>";
?>