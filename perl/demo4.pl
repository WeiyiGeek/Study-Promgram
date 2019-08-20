#!/usr/bin/perl
printf "Please input 86 F or 30 C : ";
$value = <STDIN>;
chomp($value);

#第一个括号: 整个正则表达式保存位$1
#第二个括号: 保存是输入的华氏温度还是摄氏温度保存位$2
if($value =~ m/^([-+]?[0-9]+)([CF])$/)
{
  #重点
  $number = $1; #将输入温度数据保存到变量中
  $type = $2;  #将输入变量的类型保存到变量

  #print "$type";
  #判断字符串是否相等
  if($type eq "C"){
    $cel = $number;
    $fah = ( $cel * 9 / 5 ) + 32;
  } else {
    $fah = $number;
    $cel = ($fah - 32) * 5 / 9;
  }
  #计算输入两个温度值采用printf函数(与C中函数类似)
  printf "%2.f C And %.2f F\n", $cel, $fah;
} 
