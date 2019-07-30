<?php
    //count(); 函数 案例
    $lamp = ["os"=>"Linux","Webserver"=>"Apache","db"=>"Mysql","Language"=>"PHP"];
    echo "数组的个数 ：".count($lamp)."<br>";

    $str = "l love php!";
    echo "字符串的个数 ：".count($str)."<br>";

    $web = array(
        "lamp"=>array("os"=>"Linux","Webserver"=>"Apache","db"=>"Mysql","Language"=>"PHP"),
        "javaEE"=>array("os"=>"Unix","Webserver"=>"Tomcar","db"=>"Orace","Language"=>"JSP")
    );
    echo "(默认是头层数组个数-二维数组)数组的个数 ：".count($web)."<br>";
    echo "(加上参数1,则递归子层-二维数组)数组的个数 ：".count($web,1)."<br>";

    //array_count_values(); 函数 案例 (出现的值为KEY)，(次数为value)
    $lamp1 = ["os"=>"Linux","Webserver"=>"Apache","db"=>"Mysql","Language"=>"PHP","SYSTEM"=>"Linux","data"=>"Mysql"];
    echo "<pre>值出现的次数：<br/>";
    print_r(array_count_values($lamp1));
    echo "<pre>";

    //array_unique(); //移除数组中重复的值
    echo "<pre>移除数组中重复的值：<br/>";
    print_r(array_unique($lamp1));
    echo "</pre>";
