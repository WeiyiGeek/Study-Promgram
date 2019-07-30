<?php
	echo "<b style='color:red'>以下是4种标量 : </b><br>";
	$var = true;
	var_dump($var);  //Boolean

	echo "<br>";

	$var = 1024;
	var_dump($var); //integer

	echo "<br>";

	$var = 10.24;  //float
	var_dump($var);

	echo "<br>";

	$var = "Hello,PHP!";
	var_dump($var); //String 会输出值的长度

	//
	echo "<br><br><b style='color:green'>以下是两种复合类型:</b><br>";
	$var = array("One","Two","Three");
	var_dump($var); //Array

	echo "<br/><br/>";

	class Demo {
		var $one = 10;
		var $two = "20";
		var $three = 30;
	}
	$var = new Demo;
	var_dump($var);  //Object

	//
	echo "<br><br><b style='color:blue'>以下输出两种特殊的类型:</b><br/>";
	$var = mysql_connect("localhost","root","");
	var_dump($var); //resource

	echo "<br/>";

	$var = NULL; //NULL
	var_dump($var);

?>
