<?php

	//PHP解析时候不显示提示警告信息
	error_reporting(E_ALL & ~E_NOTICE);

	/*
	 * 常量: 一旦声明， 这个常量的值就 不会被改变
	 *
	 * 1. 常量是使用函数 define()声明的
	 * 7. 常量不能使用 unset() 清除一个常量 
	 * 8. 可以使用defined(); 判断一个常量是否存在
	 *  
	 */

     $root = "localhost";
     define("ROOT", 1024);

     echo "This is a $root <br/>";
     echo ROOT;	
     echo "<br/>";
     echo constant("ROOT");  //能输出特殊->当"字符串为常量"的时候
     echo "<br/><br/>";
     
     //不区分大小写
     define("NROOT",2048, TRUE);
     echo "NROOT=". nroot;
     echo "<br/><br/>";


     //判断PHP常量是不是存在
    if(defined("NROO1T")){
        echo "NROOT-1024=".  NROOT-1024; //常量能进行四种标量的运算;
    }else{
        echo "<p style='color:rgb(112,150,50)'>Not Exsit Constant-Quantity</p>";
    }

	echo '<br>';
    //显示当前系统的存在的常量
	var_dump(get_defined_constants());

?>