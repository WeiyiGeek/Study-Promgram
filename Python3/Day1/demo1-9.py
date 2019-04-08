#!/usr/bin/python3
#coding:utf-8
#功能:数值类型转换内置函数

print("整形 : 0xa=",int('0xa',16)," 0x12=",int('12',16)," 010=",int('10',8)) #以16进制转换为整形,和8进制转换成为整形
print("浮点 :",float('123'),float(1))  #浮点类型
print("复数 :",complex(1,2),complex("1+2j"))  #转化一个字符串或数为复数 
#注意:这个地方在"+"号两边不能有空格，也就是不能写成"1 + 2j"，应该是"1+2j"，否则会报错

cdict = dict(zip(['one', 'two', 'three'], [1, 2, 3]))   # 映射函数方式来构造字典

print(str(cdict))  # 将对象转化为字符串形式。
print(repr(cdict))  # 将对象转化为供解释器读取的形式。

print(eval(' 2 ** 2'),eval('pow(2,2)'))  # 执行一个字符串表达式,可以执行python的一些数学函数和计算

print(set('runoob'),set('google'))       # 集合中重复的值被删除 set
print(frozenset(range(10)))              # 生成一个新的不可变集合 set

print(chr(48),chr(65),chr(97))       #将ASCII码 ==> 字符
print(ord('0'),ord('A'),ord('a'))    #将字符  ==> ASCII
print(hex(255),hex(15))
print("255 oct =",oct(255),"10 oct =",oct(10))
