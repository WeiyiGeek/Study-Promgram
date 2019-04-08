#!/usr/bin/python3
#功能：内嵌函数与闭包使用

#""" 内嵌函数 """
def fun1():
    print("Fun1 主函数被调用")
    def fun2():
        print("Fun2 内嵌函数正在被调用\n")
    fun2()  #内部函数（内嵌函数）,只能由fun1()调用

fun1()

#"""闭包"""
def funX(x):
    def funY(y):
        return x * y
    return funY

i = funX(8)
print("i的类型 :",type(i))
print("8 * 5 =",i(5)) #  40 由于前面已经赋值给x了,后面得就给了y=5. 
"""
类似于
>>> def funX(x):
	def funY(y):
		return x * y
	return funY(2)
>>> funX(3)
6
"""

#"""闭包进阶（采用类似于数数组的方式 -- 列表(传入的是地址)）"""
def demo1(arg):
    x = [arg]
    def demo2():
        #采用 nonlocal 关键字也行
        x[0] **= x[0]  #采用这样的方式进行取值列表 (**幂运算) | 不引用局部变量(Local variable),采用数组的方式进行暗渡成仓.
        return x[0]
    return demo2()

print("2 ** 2 =",demo1(2),"  -  5 ** 5 =",demo1(5))


#"""一个闭包的典型案例"""
def funA():
    x = 5
    def funB():
        nonlocal x   #//把x强制表示不是局部变量local variable
        x += 13
        return x 
    return funB

a = funA()  #当 a 第一次被赋值后,只要没被重新赋值,funA()就没被释放,也就是说局部变量x就没有被重新初始化。
print("第一次调用：",a(),"第二次调用：",a(),"第三次调用：",a())
