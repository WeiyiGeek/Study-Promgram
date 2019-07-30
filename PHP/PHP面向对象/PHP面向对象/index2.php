<?php
//类的继承和方法的重写
 class man extends people(){
 	public function __construct($age,$name);
 	parent::__construct($age,$name,'男');
 	public function hi(){
 		parent::hi(); //保留父类的hi()方法
 		echo $this -> _name.'say'; // 重写方法
 	}
 }

 //调用require
 $m = new man (10,'jikexueyuan');
 $m->hi();