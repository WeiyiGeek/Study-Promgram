<?php
/** 外层指定下标 则内层自动增长 **/
    $clas[0][] = "Geek";  
    $clas[0]['first'] = "Weiyi"; // 索引不包括关联
    $clas[0][] = 520;
    $clas[0][] = 1314;

    $clas[1][] = "Geek";  
    $clas[1]['first'] = "Weiyi"; // 索引不包括关联
    $clas[1][] = 520;
    $clas[1][] = 1314;
    echo "<pre>";
    print_r($clas);
    echo "</pre>";

/** 外层不指定下标 则外层自动增长 **/
    $calc[][] = "Weiyi";
    $calc[][] = "Geek";
    $calc['three'][] = 5201314;
    $calc[][] = "Hello World! php;";

    echo "<pre>";
    print_r($calc);
    echo "</pre>";
?>