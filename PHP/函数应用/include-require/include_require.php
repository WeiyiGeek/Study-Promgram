<?php
    /**
     *  include () || require() 
     *  include_once() || require_once()
     **/

    require "function.inc.php";         //建议使用该函数来包含必须引用的配置文件
    include_once "function.inc.php";    //使用该函数不会产生重复定义函数的错误
    one();
    two();
    three();
    
    echo "<br>";
    for($i = 0; $i < 5; $i++){
        if($i % 2 == 0){
            include "function.inc.txt";  //该函数最好用在判断加载中
            echo "<br>";
        }else{
            include "function.inc.html";
             echo "<br>";
        }
    }

 