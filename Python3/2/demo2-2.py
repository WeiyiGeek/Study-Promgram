#!/usr/bin/python3
#功能：实现函数功能

def fun(num1,num2):
    '函数功能：求出两个数之和'  #通过 函数名.__doc__调用函数文档
    return num1 + num2        #用return返回参数或者程序运行的结果

def saypython(name='小甲鱼',words="改变时间"):  #设置默认参数，当未给函数赋值的时候显示
    '函数文档：我们的心声'
    print(name + ' 想 ->' + words)

print("1 + 2 =",fun(1,2))
print("函数说明：(",fun.__doc__,end=")\n-------------")
print("我",saypython('weiyigeek','改变世界'))  #由于无return语句则返回none
saypython('weiyigeek','改变世界')
saypython()  #采用函数默认参数,便可以不带参数运行,因为有内置可选参数 name='小甲鱼',words="改变时间"
print("函数说明：(",fun.__doc__,end=")\n")


