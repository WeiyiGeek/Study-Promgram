<?php
/** 位运算符案例 
	 *    hello    world 
	 *    h   e    l    l   o 
	 *    104   -  是由32位0 和 1 （二进制组成）
     *    0(符号位) 0000000 00000000 00000000 01101000
     *  
     * 	  12 & 13 ==>>>
	 *    00000000 00000000 00000000 00001100 
	 *    00000000 00000000 00000000 00001101   &
	 *    --------------------------------------------
	 *    00000000 00000000 00000000 00001100  == 12
*/
echo "12 & 13 ==> ";
var_dump(12 & 13);
echo "<br><br/>";

/*    65 = 64 + 1          =  1000001 
*    97 = 64 + 32 + 1     =  1100001   | //大小写转换主要看第6位
*    ------------------------------------------
*                            1000001   A
*/
$a ='a';  //97
$A ='A'; //65
echo "'A' | 'a' ==> ";
var_dump('A' | 'a');  //输出‘a’
echo "<br/>";

echo "'a' & 97 ==> ";
var_dump('a' & 97);  //'a'字符串转成0 => 类型自动转换为0 & 97 = 0
echo "<br><br/>";

echo "//boolean类型的加减与位运算符 : ";
var_dump(true + false); // 1 + 0 = 1
var_dump(true & false); // 1 & 0 = 0
echo "<br/><br/>";


//按位与 用在不要短路求值的地方
$a = 3;
$b = 5;  
if($a > 5 & $b++ < 100)  //前腱为FALSE，但认比较后建
{
    echo  "上面表达式为假,这是不显示的,并且不会执行";
}
    echo "b1 = ",$b,"<br>";  //没有短路求值的影响（b = b+1 = 6）


//按位或 用在不要短路求值的地方
if($a > 5 | $b++ < 100)
{
    echo "b2 = ",$b,"<br/>";  //没有短路求值的影响（ b = b+1 = 7）
    echo "上面表达式为帧,这是显示的！~~·并且会执行！~ <br><br>";
}

//按位异或 0010 0000 = 32 (空格)
echo " 异或运算：";
var_dump('A' ^ 'a');

echo "<br> 按位取反：";
var_dump(~12);   //取反 = > 补码+1 = -13;
var_dump(~-13);  //取反 => 补码+1 = 12;

echo "<br> 移位运算：";
var_dump(12 >> 2);
?>

