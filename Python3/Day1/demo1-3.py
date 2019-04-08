#!/usr/bin/python3
# -*- coding:UTF-8 -*-
# 功能：基础数据类型,与输入输出函数的使用

#----integer----#
temp = input("请输入数字：")
print("输入值为 : ",temp, " | 类型:",type(temp))
temp = '5'
number = int(temp)   #将字符转成整数类型
print("字符转换整数 : ",number," | 类型:",type(number))
temp  = True
temp =  4+3j  #复数类型
print("复数:",temp," | 类型:",type(temp),end="\n\n")


##----String-----#
word = '字符串'
sentence = "这是一个句子."
paragraph = """
    这是一个段落，
    可以由多行组成
"""
A = " THIS A"
B = "String !"
C = A + B   #拼接字符串
print(C,end="\n")
print("段落:",paragraph)

#字符串的截取的语法格式如下：变量[头下标:尾下标:步长] 
str1 = '0123456789'
print(str1[0:-1])           # 输出第一个到倒数第二个的所有字符
print(str1[2:5])            # 输出从第三个开始到第五个的字符
print(str1[-6:-1])             # 到数第二个数
print(str1 * 2)             # 输出字符串两次 (关键字 * 重复)
print('数值:' + str1)       # 连接字符串 (关键字 + 拼接)

##----字符转义-----#
print('hello\nWeiyi')      # 使用反斜杠(\)+n转义特殊字符
print(r'c:\\windows')     # 在字符串前面添加一个 r，表示原始字符串，不会发生转义

