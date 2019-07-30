#!/bin/bash
#shell计算器(字符界面得加减乘除)

#输入两个数值和运算符
read -t 30 -p "Please input Num-1:" num1
read -t 30 -p "Please input Num-2:" num2
read -t 30 -p "Please input a operator:" ope

#判断输入的都有值
if [ -n "$num1" -a -n "$num2" -a -n "$ope" ];then

	#判断test1与test2是不是为空，为空就是数值(也可以利用变量测试)
	test1=$(echo $num1 | sed 's/[0-9]//g')
	test2=$(echo $num2 | sed 's/[0-9]//g')
	
	#第二层判断num1 与num2 是不是为数值
	if [ -z "$test1" -a -z "$test2" ];then
		
		if [ "$ope" == '+' ];then
			sum=$(( $num1 + $num2 ))
			echo "$num1 $ope $num2 : $sum"
			
		elif [ "$ope" == '-' ];then
			sub=$(( $num1 - $num2 ))
			echo "$num1 $ope $num2 : $sub"
			
		elif [ "$ope" == '*' ];then
			mul=$(( $num1 * $num2 ))
			echo "$num1 $ope $num2 : $mul"
			
		elif [ "$ope" == '/' ];then
			div=$(( $num1 / $num2 ))
			echo "$num1 $ope $num2 : $div"
			
		else
			echo "Please enter a Valid symbol"
			exit 10
			#退出程序，返回error代码10
		fi
	
	else
	#如果test1与test2不是数值
		echo "Please enter valid value"
		exit 11
		#退出程序，返回error代码11
	fi

else
	
	echo "请输入数值或者运算符"
	exit 12

fi

#echo $?  //输出error代码