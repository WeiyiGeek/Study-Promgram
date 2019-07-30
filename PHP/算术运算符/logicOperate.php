<?php
     /*逻辑运算符号：*/
    // && and -- || or -- ! -- XOR;

    $years = 2014;
    if(($years % 4 == 0 && $years %100 != 0) || ($years % 400 ==0))
    {
        echo "{$years} 是闰年！<br>";
    }else{
        echo "{$years} 是平年！<br>";
    }


    /* 逻辑运算特性： 短路 
    *   &&  and  ---  ||  or
    *   $a = 1;	
    *   $a > 5 && $a < 100     //为假
    *   $a > 5 || $a < 100     //为真
    */

    //短路求值的作用 (前面为假时候才执行后面的比较表达式！)
    $link = mysql_connect("localhost","root","") or die("下面的内容不再显示！程序退出 die()函数！");
    echo "如果数据库 连接成功 则显示~,否则！不显示....<br/><br/>";

    //深入理解短路求值 (非常注意符号优先级的影响)
    $a = 0;
    $b = 0;
    if($a = 3 && $b = 3)
    {
        $a++; //TRUE + 1 = TRUE (自动转换为 1 )
        $b++; //3+1 = 4
    }
    echo "a = $a , b = $b <br>";

    $c = 0;
    $d = 0;
    if($c = 3 || $d = 3)
    {   
        $c++; //TRUE + 1 = true(1)
        $d++; // 0 + 1 = 1
    }
    echo "c = $c , d = $d <br><br/>";


    //异为真,同为假（异或）
    var_dump( 1 xor 1);  //FALSE
    var_dump( 0 xor 0);
    echo "<BR/>";
    var_dump( 1 xor 0);  //TRUE
