<?php
    //传入的参数是className
    function __autoload($classname){
        echo "{$classname}<br>";
        include strtolower($classname).".class.php";
    }

    //注意类名与文件名相呼应
    $a = new demo1();
    $b = new demo2();
    
    demo3static::three();  //静态方法
    $a->one();
    $b->two();
