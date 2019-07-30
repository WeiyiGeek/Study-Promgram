<?php
	/**
	 *  别名
	 **/
	namespace  net\lampbrother\www;
	function web(){
		echo "<p style='color:red'>https://www.lampbrother.net</p>";
	}
	//method 1
	use net\lampbrother\www as http;
	http\web();

	//method 2
	use net\lampbrother\www;
	www\web();

	//method 3
	include "hello.class.php";
	class Hello {
		static function world(){
			echo "This is 局部的函数() ; <br>";
		}
	}

	Hello::world();
    http\Hello::world();
    
    //USE 只能导入一个全局的类,不能导入常量
    //use \Hello;  
    Hello::world();

    //先局部空间后全局空间
	function var_dump($a) {
		echo "<br> $a $a $a <br>";
		\var_dump($a);
	}
    var_dump(100);
    

?>
