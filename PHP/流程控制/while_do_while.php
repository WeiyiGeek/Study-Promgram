<?php
    $i=0;  //采用计算器,进行设退出循环的条件
    $result=0;
	while($i <= 10) {
        $result += $i++; // i = 0 ~ 10
        echo "reslut = {$result} <br/>";
	}

    //do .. while 语句
    $a = 0;
    do{
    echo $a++." --> ";
        $b = 0;
        do {
            $b++;
            echo "@_@|";
        }while($b < 10);
        echo "<br>";
    }while($a < 10);
