<?php
/* 比较运算符号 */
// 1. 比较后的结果是一个boolean值, 用在if和while等语句中
// 2.4 > 3 true

$a = "007"; //string
$b = 7;     //integer

var_dump($a == $b);
echo "<br/>";
//全等 ： 不仅值相等而且要求类型也相等
var_dump($a === $b);
echo "<br/><br/>";

//不全等-类型与值有一样不相等都为True
var_dump($a !== $b);

echo "<br/><br/>";
//注意浮点数用大于或者小于进行比较运算,不建议用等于或者全等于进行比较（精度不同）
var_dump( 0.07 > 0.0699999999);
echo "<br/>";
var_dump(7.00 <= 7);  //浮点数与整型进行比较
?>