#!/bin/bash
#接受 输出得参数(Arguments)
#位置参数
num1=$1
num2=$2
echo -e "输入得参数:"
echo $num1,$num2
let num3=$num1+$num2  #Add输入得参数
echo -e "num1+num2=\e[1;35m $num3 \e[0m"
##
echo -e "\n代表所有参数的个数:"
echo -e " A total of\e[1;32m $# \e[0m Parameters"   #所有参数的个数:
##
echo -e "\n整体参数:"
for i in "$*"
    do
        echo -e "ioutput:\e[1;31m $i \e[0m"   #整体参数
    done
##
echo -e "\n个体参数:"
for j in "$@"
    do
        echo -e "joutput:\e[1;36m $j \e[0m"   #个体参数
    done
