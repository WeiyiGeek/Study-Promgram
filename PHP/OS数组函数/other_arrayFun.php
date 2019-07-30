<?php
    /** 其他数组函数  */
    $arr = ['a','b','c','d','e'];
    echo "<pre>随机下标:<br>";
    var_dump(array_rand($arr,3)); //随机取三个下标


    echo "<br>打乱数组:<br>";
    shuffle($arr);  //打乱数组
    print_r($arr);

    echo "<br>计算数组的和:<br>";
    $a = [1,2,3,4,5];
    echo "1+2+3+4+5 =".array_sum($a)."<br>";

    echo "<br>建立一个范围的数组:<br>";
    $b = range(1,10,2); //以step 2 进行递增
    print_r($b);

    echo "<br>给定的值填充数组:<br>";
    $c = array_fill(0, 5,"banana");
    print_r($c);

    echo "</pre>";