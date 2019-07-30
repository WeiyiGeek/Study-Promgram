#!/bin/bash
#if分支语句
read -p "Please INput A:" a
read -p "Please INput B:" b
read -p "Please INput C:" c	
#单分支语句(1)
if [ $a == $b ];then
	echo "a is equal to b!!" 
fi

if [ $a != $b ];then
	echo "a is not equal to b!!"
fi
#单分支语句(2)
if [ $c == $b ];then
	echo "c is equal to b!!"
else
	echo -e "c is not equal to b!!\n"
fi

#双分支语句
a=10
b=20
if [ $a == $b ]
then
   echo "a is equal to b"
elif [ $a -gt $b ]
then
   echo "a is greater than b"
elif [ $a -lt $b ]
then
   echo "a is less than b"
else
   echo "None of the condition met"
fi
