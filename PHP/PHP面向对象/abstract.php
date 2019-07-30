<?php
	//抽象类不能使用使用new Person来申请对象（importment）
	abstract class Person {
		public $name;
		public $age;
		abstract function say();  //特殊的方法抽象方法的存在
		abstract function eat();
	}

	//对于抽象类的子类,将抽象方法进行覆盖
	class StudentCn extends Person {
		function say() {
			echo "<p style='color:red'>我是中国人，我说中文<br>";
		}

		function eat() {
			echo "我是中国人，我用筷子吃饭</p><bt>";
		}
	}

	class StudentEn extends Person {
		function say() {
			echo "<p style='color:green'>I am English ，i say english<br>";
		}

		function eat() {
			echo "我是外国人， 我用刀子和叉子吃饭</p>";
		}
	}

	//通过子类来申请对象；
	$cn = new StudentCn();
	$cn -> say();
	$cn -> eat();

	//通过子类来申请对象；
	$en = new StudentEn();
	$en -> say();
	$en -> eat();