<?php
/***
 *  PHP中异常处理
 *  try {
 *      #code
 *  }catch(Exception $e){
 *      #code
 *  }
 * 
 */
error_reporting(E_ALL);
//example 1.比如下面这个上班流程为列简单的验证try catch的使用

    echo "起床<br>";
try{
    echo "开车<br>";
    //抛出异常 new 一个对象进行传递异常
    throw new Exception("Error Processing Request");  //下面的语句将不会执行
    echo "一路畅通";

}catch (Exception $e){  //这里 $e 相对于实例化Exceptionl类  = new Exception("Error Proccessing Request");
   
    echo $e->getMessage()."<br>";  // 利用 $e 调用 Exception 类的构造函数; 
    echo "一路拥挤 <br>";
}
	echo "公司 <br><hr/><br/>";



//Example 2. 将php错误级别与异常结合起来

set_error_handler("foo");

function foo($error_level,$error_messages,$file,$line){
	if($error_level == E_WARNING){
		throw new Exception("<p style='color:red'>这是抛出异常了 - 问题如下 {$error_messages} - in - {$file} - num {$line} </p>");
	}
}

function test($va){
	echo $va."<br>";
}


echo "开始加载 <br/>";

try{ 

	echo "正在加载 <br/>";
	//test("Loading ......");
	//下面模拟警告提示
	test();

}catch (Exception $e){
	echo $e->getMessage();
	echo "加载异常 <br/>";
}

echo "加载完毕 <br/>";


?>
