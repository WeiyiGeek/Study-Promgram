#!/usr/bin/python3
# -*- coding:UTF-8 -*-
# 功能：变量的定义与使用

int1 = 23
float1 = 100.0
string = "WeiyiGeek" 
print("姓名：",string,"年龄：",int1, "分数：", float1,end="\n") 

a = b = c = 1   #创建一个整型对象，值为 1，从后向前赋值，三个变量被赋予相同的数值
print(a,b,c,end="\n") 

a,b,c = 1, 2, "WeiyiGeek"  #两个整型对象 1 和 2 的分配给变量 a 和 b，字符串对象 "runoob" 分配给变量 c。
print(a,b,c,end=" ")



