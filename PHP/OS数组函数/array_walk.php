<?php

    //array_walk(); 利用回调函数处理值
    $arr = [1,2,3,4,5];
    function Myfun($value){  //回调函数这里参数非常重要 （引用地址）
        echo "CallBack Function ：".$value."<br>";
    }
    print_r($arr);
        echo "<br>";
    array_walk($arr,"Myfun");      //对数组中的每个成员应用用户函数
    print_r($arr);
        echo "<br>";
    function Myfunaddr(&$value1){  //（引用地址）,传入数组元素的值,更改后返回在数组中
        $value1 *= 2;  
    }
    array_walk($arr,"Myfunaddr");  //可以直接修改数组里面元素的值
    print_r($arr);
        echo "<br><br><br>";


    //array_walk(); 利用回调函数处理键和值
    $arr = ["one"=>1,"two"=>2,"three"=>3,"four"=>4];
    function test($value, $key){
        echo "{$key} ===> ${value} ";
    }
    print_r($arr);
        echo "<br>";
    array_walk($arr,"test");
        echo "<br>";
    //下面采用匿名函数来进行键值的处理
    array_walk($arr,function(&$value, $key){
            echo "{$key} ===> ".$value=$value*$value." ";
    }); 
        echo "<br>";
    print_r($arr);

        echo "<br>";
        echo "<br>";
    //array_walk(); 第三个参数的使用
    $arr1 = ["one"=>1,"two"=>2,"three"=>3,"four"=>4];
    array_walk($arr1,function($value, $key, $str){
        echo "{$key} {$str} {$value} <br>";
    },"-##############-");



