#!/bin/bash
#while Circulation
num=0
sum=0
while [ $num -le 100 ]
do
	sum=$(($sum+$num))
	num=$[$num+1]
done
echo "1+2+....+100=$sum"

#Until Circulation
#输出 0 - 4
a=0 
until [ ! $a -lt 5 ]   #到5得时候就不成立了
do
	echo $a
	a=`expr $a + 1`
done
echo -e "\n"
#输出 0 - 5
b=0
until [ $b -gt 5 ]   # 可以等于5
do
	echo $b
	b=$(($b+1))
done
