<?php
/***
 * 将函数名以字符串的形式赋值给变量,然后变量后加上(),便成了变量函数;
 * @function ： 加减乘除
 * @param 1：number $a
 * @param 2： number $b
 * @return :number var_function()
 */
function add($a, $b){
    return ($a + $b);
}

function sub($a, $b){
    return ($a - $b);
}

function mul($a, $b){
    return ($a * $b);
}
function div($a, $b){
    //除法除数不能为0
    if($b != 0){
        return ($a / $b);
    }else{
        return false;
    }
}

$var_func = "add"; //将函数名给变量
echo "1 + 1 = ".$var_func(1,1)."<br><br>";  //这里进行变量名的替换函数->达到变量函数

$var_func = "sub";
echo "2 - 1 = ".$var_func(2,1)."<br><br>";

$var_func = "mul";
echo "6 * 6 = ".$var_func(6,6)."<br><br>";

$var_func = "div";
echo "9 / 7 = ".$var_func(9,7)."<br><br>";


