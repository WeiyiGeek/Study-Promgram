#!/bin/bash
echo "#变量叠加与单双引i号得异同"

x=123
y="$x"456
y=${y}789 
echo -e "y=\e[1;32m $y \e[0m"

z='$y'   # 单引号 不能引用变量 'character':表示字符串
a="$y"  # 双引号 引用变量 特殊符号有特殊意义 \\ \n

b="$x"
c='"$x"'   
echo -e "z=\e[1;37m '$z' $a \e[0m"
echo -e "$c=\e[37;1;5m $b \e[0m"
