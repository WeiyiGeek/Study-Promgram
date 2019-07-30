<?php
    //数组的交集intersect 与 差集diff
   
    $a = array(5,6,10,12,13,15,14);
    $b = array(5,6,17,13,14);

    //采用交集的函数 
    print_r(array_intersect($a,$b)); // 5 10 13 14
    echo "<br>";
    //采用自定义函数来取特定的一段数组 (取开头相同的)
    $minlen = (count($a) > count($b)) ? count($b) : count($a);
    $arr = array();
    for($i = 0; $i < $minlen; $i++){
        if($a[$i] == $b[$i]){
            $arr[] = $a[$i];
        }else {
            break;
        }
    }
    print_r($arr);
    echo "<br><br>";


    //采用差集的函数
    print_r(array_diff($a,$b)); // 10 12 15 （去掉重复的）
    echo "<br>";