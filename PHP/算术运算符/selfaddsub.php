<?php
/** 自增 与 自减 -> 只支持整型其他类型不参加  */
echo "<b style='color:red'>PHP的 自增++ 与 自减-- 浮点数/整型</b><br>";
$a = 5;  //整数与浮点数
$b = $a++;  //先赋值后+1
echo "$b <--> $a <br>";

$c = ++$a;  //先+1后赋值
echo "$c <--> $a <br>";
//a = 7
$c = $a++ + ++$a;
echo "c = $c -- a = $a <br><br>";


//boolean类型不参与自增与自减
echo "<b style='color:red'>PHP的 自增++ 与 自减-- boolean类型不参与</b><br>";
$bool = true;
//$bool = FALSE;
$b = $bool + 1;  //由于TRUE=1,则为2
var_dump($b);
echo "$b<br>";

$bool++; //都是为1
++$bool;
var_dump($bool);
echo "$bool<br><br><br>";

//字符与字符类型也不参与自增与自减
echo "<b style='color:red'>PHP的 自增++ 与 自减-- 字符与字符类型不参与</b><br>";

$charx = 'x';
$cnum = $charx + 1; //输出为1;
var_dump($cnum);
echo "$cnum<br>";

//自增只是字符单纯的加1,注意下面的z过了循环
$charx++;  //y
var_dump($charx);
echo "<br>";
$charx++;  //z
var_dump($charx);
echo "<br>";

$charx++;  //aa
var_dump($charx);
echo "<br>";
?>