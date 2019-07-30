<?php

	//声明一个接口使用interface
	interface Demo {
		const NAME="妹子";
		const AGE = 20;

		//接口中方法必须是公共的
		function test1();
		public function test2();
	}

	interface Test extends Demo {
		function test3();
	}

	interface Test1 {
		function test4();
	}

	class World {
		function test5() {
			echo "#####<br>";
		}
	}

	//实现类与接口
	class Hello extends World implements Test,Test1 {
		function test1(){
			echo "#<br>";
		}

		function test2(){
			echo "##<br>";
		}

		function test3(){
			echo "###<br>";
		}

		function test4(){
			echo "####<br>";
		}
	}
	$h = new Hello;
	$h->test1(); $h->test2(); $h->test3(); $h->test4(); $h->test5();
	 
	echo  "<br>----------------------------- 分割线 ------------------------------<br>";

	//抽象类与接口
	abstract class abs extends world implements Test,Test1  {
		function test1(){
			echo "#<br>";
		}

		function test2(){
			echo "##<br>";
		}

		/*
		function test3(){
			echo "###<br>";
		}*/
		
		function test4(){
			echo "抽象方法的重写<br>";
		}
	}

	abs::test1();
	abs::test2();
	//abs::test3();
	abs::test4();
	abs::test5();









