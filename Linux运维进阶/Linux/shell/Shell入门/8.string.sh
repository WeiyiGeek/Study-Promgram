#!/bin/bash
string="alibaba is a great company"
echo "$string"
echo -e "获取字符串长度:${#string} \n"
echo -e "提取子字符串:${string:0:5} \n"
echo "查找子字符串alibaba:`expr index "$string" alibab`"
