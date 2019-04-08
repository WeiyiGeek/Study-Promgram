#!/usr/bin/python3
#coding:utf-8
#功能:特殊运算符号验证demo

#"""Python算术运算符"""
print("2 / 4 = ", 2 / 4)   #除法 , 得到浮点数
print("2 // 4 = ",2 // 4)  #除法 , 得到整数
print("2 ** 4 = ",2 ** 4)  #乘方 ，(优先级最高)
print("5 % 4 = ",5 % 4)   #取余 ，

#"""比较运算符###
a = 1
b = 2
if ( a == b ):
   print ("1 - a 等于 b")
else:
   print ("1 - a 不等于 b")

#"""赋值运算符###
c = a + b
c += 1
print("C值为：",c)
c **= c
print("C值为：",c)

#"""Python位运算"""
a = 1
b = 8
print("a&b = ", a&b)  #与
print("a|b = ", a|b)  #或
print("a^b = ", a^b)  #亦或
print("~a = ", ~a)    #取反
print("a<<2 = ", a<<2)   #左移动

#"""Python逻辑运算符"""
a = 1
b = 2
print((a and b))  #如果 x 为 False，x and y 返回 False，否则它返回 y 的计算值。
print((a or b))   #如果 x 是 True，它返回 x 的值，否则它返回 y 的计算值。
print(not(a or b)) # 如果 x 为 True，返回 False 。如果 x 为 False，它返回 True。


#"""Python成员运算符"""
a = 10
b = 5
list = [1, 2, 3, 4, 5 ]
if(a in list):
    print("a 在list列表里面")
else:
    print("a 不在list列表里面")

if(b not in list):
    print("a 不在list列表里面")
else:
    print("b 在list列表里面")

#"""Python成员运算符"""
a = 20
b = 20
if ( a is b ):
   print ("1 - a 和 b 有相同的标识")
else:
   print ("1 - a 和 b 没有相同的标识")
#注： id() 函数用于获取对象内存地址
if ( id(a) == id(b) ):
   print ("2 - a 和 b 有相同的标识")
else:
   print ("2 - a 和 b 没有相同的标识")


a,b,c,d,e = 20,10,15,5,0
#"""算术运算符优先级验证""" 
e = (a + b) * c / d       #( 30 * 15 ) / 5
print ("(a + b) * c / d 运算结果为：",  e)
 
e = ((a + b) * c) / d     # (30 * 15 ) / 5
print ("((a + b) * c) / d 运算结果为：",  e)
 
e = (a + b) * (c / d);    # (30) * (15/5)
print ("(a + b) * (c / d) 运算结果为：",  e)
 
e = a + b * c / d;      #  20 + (150/5)
print ("a + (b * c) / d 运算结果为：",  e)