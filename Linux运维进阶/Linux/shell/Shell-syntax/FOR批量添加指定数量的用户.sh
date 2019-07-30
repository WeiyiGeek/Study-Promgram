#!/bin/bash

read -t 30 -p "Name:" name
read -t 30 -p "Number of user:" num
read -t 30 -p "password of user:"  password

if [[ ! -z "$name" -a ! -z "$num" -a ! -z "$password" ]]; then
	#statements
	y=$(echo $num | sed 's/[0-9]//g')
	if [ -z "$y" ];then
		for (( i = 0; i < $num; i++ )); do
			#statements
			/usr/bin/useradd $name$i &>/dev/null
			echo $password | /user/bin/passwd --stdin $name$i &>/dev/null
			#stdin将$password值接收赋予用户
		done
	fi
fi
