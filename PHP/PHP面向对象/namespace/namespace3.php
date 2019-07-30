<?php
	//声明一个名子空间， 前缀为 meizi
	namespace  meizi\pl;
	const AAA = "CONST";
	class Demo {
		static function one() {
			echo "STATIC ONE<br>";
		}
	}
	function test() {
		echo "FUNCTION TEST<br>";
	}

	test();
	\meizi\pl\test();

	echo AAA."<br>";
	echo \meizi\pl\AAA."<br>";


	Demo::one();
	\meizi\pl\Demo::one();
