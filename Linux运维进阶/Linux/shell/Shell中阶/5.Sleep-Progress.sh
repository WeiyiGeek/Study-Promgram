#!/bin/bash
#sleep延迟精度条案例
b='' 
for ((i=0;$i<=100;i++))
do 
    printf "Progress:[%-100s]%d%%\r" $b $i  # 输出[100个占为符号] 输出百分之几 
    sleep 0.1 
    b=#$b   # 输出'#'还在不断叠加
done
echo


