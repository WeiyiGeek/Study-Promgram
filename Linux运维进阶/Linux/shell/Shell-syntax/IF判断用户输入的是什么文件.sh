#!/bin/bash
#判断用户输入的是什么文件

read -t 30 -p "Input a File:" file

if [ -z "$file" ];then
	echo "请输入文件name"
	exit 10

elif [ ! -e "$file" ];then
#判断file文件是不是存在,如果不存在为假，取反为真则显示
	echo "Your input is not a file!"
	exit 11

elif [ -f "$file" ];then
	echo "$file is a ordinary file !"
	
elif [ -d "$file" ];then
	echo "$file is a directory file!"
	
elif [ -L "$file" ];then
	echo "$file is a Link File!"
	
else
	echo "$file is an other	file!"
fi
