#!/usr/bin/python3
#功能：使用匿名函数
import math

#函数定义
sum = lambda arg1,arg2: arg1 + arg2
sum.__doc__ = '函数文档'

#调用匿名函数
print("1 + 99 相加后的值 :",sum(1,99))
print(sum.__doc__)


#进阶用法和BIF内置函数filter/map的使用
#匿名函数进阶 (设置过滤函数，返回可以不可以整除2的数值)
show = list(filter(lambda x: x % 2,range(10)))
print(show)

#进行
show = list(map(lambda x:x % 2,range(10)))
print(show)

#过滤出1~100中平方根是整数的数：
print(list(filter(lambda x: math.sqrt(x) % 1 == 0,range(100))))
