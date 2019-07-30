#!/bin/bash
# read input Variable
read -t 10 -p "Please Input Accounts:" user
read -n 12 -s -p "Please Input Password:" pass
echo "输出的用户:$user"
echo "输入的密码:$pass"

## While Read Line 绑定文件描述
echo -e "\e[1;32m 第一个文件输出\e[0m"
exec 3<>file.txt
while read line<&3
    do
	echo $line
    done

## Cat FILE.TXT 读取文件中每一行
echo -e "\e[1;35m 第二个文件输出\e[0m"
cat file1.txt |\
	while read line
	do
		echo $line
	done
