<?php
    /**
     * 加深闭包函数的理解 
     * 
     */

    //在函数中把匿名函数返回，并且调用它
    function main(){
        $n = 1;
        $j = 10;
        $anonymouse = function($str) use(&$n, &$j){         //这里的use是使用的匿名函数外部的变量 （closure|闭包）
            echo "{$str} <br/>";
            $n++;$j++;
            echo "Name = {$n} , job = {$j} <br/>";        //引用的形参是外部变量的地址,改变闭包函数外部的值 $n / $j
        }; //非常注意闭包函数后有;号
        return $anonymouse;  //这里返回匿名函数的变量名
    }
    $resultfun = main();
    $resultfun("Demo 1 : ");  //直接调用闭包函数
    $resultfun("Demo 2 : ");  //第二次调用闭包函数
    echo "<br><br>";

   
    //把匿名函数当做参数传递||也可以直接将匿名函数进行传递,并且调用它 (js常用到)
    function demo($fun) {
		echo $fun();
    }
    $func = function($a = 1, $b = 2){
        return "a + b = ".($a + $b);
    };
    demo($func);
    echo "<br>";

	demo(function(){
		return "@2222222222222222@<br>";
	});
	demo(function(){
		return "#111111111111111#<br>";
	});
