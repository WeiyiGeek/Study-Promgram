<?php
/*
 *   静态变量
 *   1. 在函数中声明的静态变量,只在第一次调用时声明.
 *   2. 第二次以后,一看是静态变量,就先到静态区中,看一下有没有这个变量, 如果有就使用, 而不去再声明 
 *   3. 静态变量,在同一个函数多次调用中 共享 
 *
 */

    function demo($a) {
        static $result = 0;  //建立静态变量
	    $result += $a;
	    echo "result=".$result."<br>";
    }

    /**两个不同函数之间 , 定义重名的静态变量是独立的 **/
   function test() {
   	    static $result;  //建立静态变量
        $result++; 
        echo "ResultT=".$result."<br/>";
   }

   demo(1);
   demo(1);
   echo "<br>";
   test();
   test();
   test();
   test();
   echo "<br>";
   demo(1);
   demo(1);
