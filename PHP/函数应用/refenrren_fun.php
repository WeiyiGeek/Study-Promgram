<?php
    /****
     * 1. 只有在内存中的变量， 才有地址
     * 2. 有引用关系的两个变量， 一个变， 另一个就变， 相当于两个是一个
     * 
     * 如果在函数说明中， 有&出现， 说明这个参数是一个引用参数， 你调用时传参数时， 就必须传一个变量
     * 
     */

    //使用常规参数传值
    function test($arg){
        $arg = 200;
        echo "函数内部(\$arg) ：";
        var_dump($arg);
    }
    $var = 100;
    test($var);
    echo "<br>函数外部(\$var) : ";
    var_dump($var);
    echo "<br><br>";

    //使用 "&" 引用参数传值
    function text(&$arg){  
        $arg = 2048; //上面实际获取的是var变量的地址,改变的也是var的值
        echo "函数内部(\$arg)实际是外部变量var的地址：";
        var_dump($arg);
    }
    $var = 1024;
    text($var);
    echo "<br>函数外部(\$var)传入的变量 : ";
    var_dump($var);
