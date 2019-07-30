<?php
/**
 * 常量与函数的案例
 */
	namespace test;
	include "func.inc.php";
	define("test\ROOT", "<p>main.php</p>");

	function one() {
		echo "main.php :aaaaaaaaaaaaa<br>";
	}
	function two() {
		echo "main.php :bbbbbbbbbbbbbbb<br>";
	}

	one();
	\one();

	two();
	\two();

	echo ROOT;
	echo \ROOT; 

?>

