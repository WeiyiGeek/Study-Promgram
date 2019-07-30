<?php
//成员方法和类方法
// require 'Public/Hello.php';
// Hello::sayHello(); //Hello为类名

 class PHP{
 	Public function cms();
 	PHP::$Num++;
 		if(PHP::$Num>PHP::MAX_MAN_NUM){
 			throw new Exception("不能创建更多的人了！", 1);
 		}
 	}
 	private static $Num = 0; //指明变量（静态）
 	const MAX_MAN_NUM = 200; //指明常量
 }

 //调用
 	require 'index1.php';
		for($i=0;$i<200;$i++){
			new Man(10,'jikexueyuan');
		}