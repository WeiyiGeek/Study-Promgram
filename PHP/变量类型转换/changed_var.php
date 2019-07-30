<?php
/*
 *  数据类型之间的转换
 *  一、强制转换
 *  	var_dump();
 *  	getType(变量);
 *  	1. setType(变量， 类型);  ----- 是将原变量给转换
 *  	2. 在变量使用时，前面加上类型符号，转 ---- 是在赋值时给新变量一个新类型，原变量类型不变
 *  	3. intval(), floatval()  strval();
 */
echo "<b style='color:red;'>强制转换</b><br>";
 $intge = 1024;
 setType($intge,"String");   //$intge 变量本身发生变化
 var_dump($intge);
 echo "<br>getType() ==>".getType($intge)."<br>";
 echo "<br>";

 $str = "1024Hello_wrold!";
 $strArray = (array)$str; //强制将str变量转换的类型赋值给新的变量,强制转换源类型不会变
 var_dump($strArray);
 echo "<br>getType() ==>".getType($strArray)."<br><br>";

 $intg = 520;
 $d = floatval($intg);  //强制转换源类型不会变
 var_dump($d);
 echo "<br>getType() ==>".getType($d)."<br>";

 $d = strval($intg);
 var_dump($d);
 echo "<br>getType() ==>".getType($d)."<br><br>";


/**二、自动转换**/
echo "<b style='color:red;'>自动转换</b><br>";

  $a = "string is a demo";
  $b = 1024;
  $f = $a + $b;  //根据自动变换的图表进行转换
  var_dump($f);
  echo "<br>getType() ==>".getType($f)."<br><br>";

  $d = "520Hello world";  //整型模式也能获取,但只限于数字再字符串的头部
  $g = $d + $b;
  var_dump($g);
  echo "<br><br>";
  $e = "520e3Hello world";  //指数形式也能自动转换
  $h = $e + $b;
  var_dump($h);

?>
