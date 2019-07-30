<?php	
/***	
 *  函数内部声明的变量， 只能在函数内部调用, 这就是--------局部变量
 *  函数的参数,就是一个局部变量, 声明成形成的, 可以在调用时, 给值传值
***/
	$a=0;
    function print_A(){ 
        $a = 3;	//定义局部变量
        echo "在函数中显示局部变量 a 值: $a <br>";
        return $a; 
    }
    $b = print_A();
    echo "在函数外显示局部变量 a 传出的值: $b <br>";
	echo "在函数外显示变量 a 值: $a <br><br><br>"; 


/***
 * 	全局变量,在函数外部声明的变量,可以在每个函数中使用。 （顺序）
 *  在函数内部如果需要使用函数外部的变量,需要使用global关鍵字,将外部变量引入
***/
	$c = 1024;
	function print_B(){
		global $c;  //函数内部声明全局变量
		echo "<p>函数内部调用全局变量 -> {$c}<br>";
		$result = ($c * 10);
		return $result;
	}
	echo "在函数外输出我们建立的\$c变量 ：{$c} ";
	echo "函数调用执行的结果 : ".print_B()."<br><br><br>";



/**
 * 	常量可以直接进行调用（不分函数内部与函数外）
 * 	
 * **/	

	define("NUM",18523579132);
	function often(){
		echo "函数内部调用NUM常量 :".NUM."<br>";   //注意常量不加$
		return -1;
	}
	echo "函数外调用NUM常量 :".NUM."<br>";
	often();


        $_GET['a'] =1024 ;

        function test(){
            echo $_GET['a'];
        }
        test();