#!/bin/bash
#数组案例
read -p "Please Input Data Array:" -a array_name
echo -e "\e[1;32mAll Array Arguments:${array_name[*]} \n"
### 取得数组元素的个数
### length=${#array_name[*]}
### echo $length
echo -e "\e[1;36mArray Arguments Accounts:${#array_name[*]} \e[0m\n"
### 取得数组单个元素的长度
echo "array_name[1]:${array_name[1]}"
echo -e "\e[1;37mSingle Array Arguments(array_name[1]):${#array_name[1]} \e[0m\n"
