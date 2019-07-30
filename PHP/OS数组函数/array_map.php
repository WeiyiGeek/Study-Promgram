<?php
    $arr = array(1,2,3,4,5);
    //array_map();函数返回一个数组
    $rarr = array_map(function($value){
        return $value*$value*$value;
    },$arr);
    echo "<pre>调用第一个匿名函数后：<br/>";
    print_r($rarr);
    echo "<br/>";

    //操作两个数组
    $brr = array("one","two","three","four","five");
    $rarr = array_map(function($a,$b){
        return "{$b} : ${a}";
    },$arr,$brr); //传入两个数组,这时回调函数中也包含两个形参
    echo "调用第二个匿名函数后(多个数组)：<br/>";
    print_r($rarr);
    echo "<br/>";


    //当函数参数的回调函数函数为NULL,将传入的几个数组变成二维数组;
    echo "当函数参数的回调函数函数为NULL,将传入的几个数组变成二维数组：<br/>";
    $rarr = array_map(NULL, $arr, $brr);
    print_r($rarr);
    echo "</pre>";
