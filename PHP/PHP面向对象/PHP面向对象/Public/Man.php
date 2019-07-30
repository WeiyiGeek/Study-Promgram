<?php
/**
 * @param int $age 年龄
 * @param string $name 名字
 */
	// class Man{
	// 	public function __construct(){ //可以执行类的时候直接执行该__construct函数
	// 		echo 'construct a Man';
	// 	}
	// }
	class Man{
		public function __construct($age,$name){
			$this -> _age =$age;
			$this -> _name = $name;
			Man::$Num++;
 			if(Man::$Num>Man::MAX_MAN_NUM){
 				throw new Exception("不能创建更多的人了！", 1);
 			}
		}
		public function getAge(){
			return $this -> _age;
		}
		public function getName(){
			return $this -> _name;
		}
		private $_age,$_name;
		private static $Num = 0; //指明变量（静态）
 		const MAX_MAN_NUM = 200; //指明常量
	}