#!/usr/bin/python3
#coding:utf-8
#功能：字符串类型详解

var = "Hello"
print("拼接字符串：\a",var[:5]+" World!")

#原始字符串除在字符串的第一个引号前加上字母 r（可以大小写）以外，与普通字符串有着几乎完全相同的语法
print (r'\n')
print (R'\n')

print("我叫 %s 今年 %d 岁 %#X  数值：%5.3f" % ('小明',10,255,12.85455))
print("\u6211\u662f\u6700\u559c\u7231\u0050\u0079\u0074\u0068\u006f\u006e") #unicode 输出