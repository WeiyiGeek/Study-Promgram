<?php
  // require_once 'public/Hello.php';
  // require_once 'public/Hello_1.php';


  // $h = new Hello(); //创建一个新的实例
  // $h -> sayHello(); //通过实例访问class类的定义

  // $h = new \jkxy\Hello(); //创建一个新的类名空间jkxy实例
  // $h -> sayHello(); //通过实例访问class类的定义
  // $h = new \jikexueyuan\Hello();//创建一个新的类名空间jikexueyuan实例
  // $h -> sayHello();

  // require_once 'public/Man.php';
  // $m = new Man(); //创建一个新的类执行方法、就可以直接执行_construct函数的内容不用在访问定义
	
	// require_once 'public/Man.php';
	// $m = new man(10,'jikexueyuan');  //可以传递参数
	// echo $m -> getName();

	require 'Public/Man.php';
		for($i=0;$i<200;$i++){
			new Man(10,'jikexueyuan');
		}