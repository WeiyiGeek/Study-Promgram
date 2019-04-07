#!/usr/bin/python3
#coding:utf-8
#功能：数学函数验证
import math  #需要导入数学的包

# 常量
print(math.pi,math.e)  #3.141592653589793 2.718281828459045

#max / min 判断最大值/最小值
print(max(1,2))  #2
print(min([1,2,3],[2,3,4])) #[1,2,3]
print(math.ceil(1.2))  #2
print(math.floor(1.2)) #1
tup = math.modf(1.8) 
print("math.modf(1.8)",tup[1],tup[0])  #1.0 0.8
print(pow(5,2)) # 25
print(round(8.5)) #四舍五入（注意当小数部分只有5时候还是舍弃，整数部分不进位）8
print(round(8.51))   #9
print(math.sqrt(10)) #3.1622776601683795
