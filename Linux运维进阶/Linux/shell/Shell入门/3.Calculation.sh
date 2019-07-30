#!/bin/bash
#五种计算方法Method

va=$1
vb=$2
echo -e "输入的参数:$va,$vb \n"

##
echo -e "\e[1;36m #Method 1 '$[exp]' \e[0m"
echo "va+vb=$[$va+$vb]"

##
echo -e "\n\e[1;35m #Method 2 '$((exr))' \e[0m"
echo "va+vb=$(($va+$vb))"

##
echo -e "\n\e[1;34m #Method 3 'let x=1+1' \e[0m"
let vc=$va+$vb
echo "va+vb=$vc"

##
echo -e "\n\e[1;33m #Method 4 'expr 1 + 1' \e[0m"
result=`expr $va + $vb` #注意加号两边的空格
echo "va+vb=$result"

##
echo -e "\n\e[1;32m #Method 5 'declare -i x=1+1' \e[0m"
declare -i vd=$va+$vb
echo "va+vb=$vd"
