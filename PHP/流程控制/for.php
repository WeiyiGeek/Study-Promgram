<?php
    //(!Study)
    for($i = 0, $j = 10; $i < 10 || $j > 0; $i++, $j--)  //自增条件可以多个
    {
        echo "{$i} I Love BINLING!  -->> 当前比例 {$j} <br>";
    }

    // 9 x 9 乘法表
    echo '<br><h4> 99 乘法表 </h4>';
    for($i = 1; $i <= 9; $i++){
        for($j = 1; $j <= $i; $j++){
            echo "$i * $j =".($i*$j)."&nbsp;&nbsp;&nbsp;";  //非常值得学习
        }
        echo '<br/>';
    }