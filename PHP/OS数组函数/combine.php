<?php

    //array_slice(); 案例  //
    $a = ["A",'B','C','D','E',"F"];
    print_r(array_slice($a,1,3));echo "<br/>";  // b c d
    print_r(array_slice($a,-1,1));echo "<br/>"; // f (负数就是倒数)
    print_r(array_slice($a,3,2,true));  //保持原数组下标 
    echo "<br/><br/>";


    //array_splice(); 案例 //替换
    $b = ["a",'b','c','d','e',"f"];
    array_splice($b,1,2,array("Replace1","Replace2"));echo "<br/>"; // b , c 替换
    print_r($b);
    array_splice($b,-3,2,array("Replace3","Replace4"));echo "<br/>"; //d , e 替换
    print_r($b);
    echo "<br/><br/>";


    //array_combine(); 案例 //结合
    $ar = ["A",'B','C','D','E',"F"];
    $br = [1,2,3,4,5,6];
    $arr = array_combine($ar,$br); //将前一个数组作为下一个数组的key
    print_r($arr);
    echo "<br/><br/>";


    //array_merge(); 案例  //拼接
    $ar = ["A",'B','C','D','E',"F"];
    $br = [6=>1,2,3,4,5,6];
    $cr = $ar + $br;   //注意下标相同的会被覆盖（）,所以上面我采用了6=>1使其不被覆盖
    print_r($cr);

    $ar = ["A",'B','C','D','E',"F"];
    $br = [1,2,3,4,5,6];
    $dr = array_merge($ar, $br);echo "<br/>";  //使用函数可以直接拼接
    print_r($dr);

    $ar = ["A","one"=>'B','C','D','E',"F"];   //关联数组后面的将覆盖前面的,索引不会被覆盖
    $br = [1,"one"=>2,3,4,5,6];
    $dr = array_merge($ar, $br);echo "<br/>";  
    print_r($dr);