#!/bin/bash
#提取文件名，删除后缀

#right最短匹配 “text”
file_name="text.gif"
echo -e "\e[1;32mFile_Name: ${file_name} \e[0m"
name=${file_name%.*}
echo file name is: $name

#left最长匹配 “test”
file_name1="test.tar.gz"
echo -e "\e[1;32mFile_Name: ${file_name1} \e[0m"
name1=${file_name1%%.*}
echo file name1 is: $name1

#贪婪%%与非贪婪%
file_name="text.gif.bak.2012"
echo -e "\e[1;32mFile_Name: ${file_name} \e[0m"
name=${file_name%.*}
name2=${file_name%%.*}
echo file name is: $name
echo file name is: $name2
