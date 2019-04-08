#!/usr/bin/python
import time
 
#案例1:funcA(funcB(func(4)))
def funcA(A):  #注意形参
    print("function A")

def funcB(B):
    print(B(2))  #B(2) 实际是传入到func中 func(2) s所以会答应c**2的值
    print("function B")

@funcA
@funcB
def func(c):
    print("function C")
    return c**2

######### 执行结果.START########
# function C
# 4
# function B
# function A
######### 执行结果.END########


#案例2：函数
def timeslong(func):  #这样这里的 func 形参,就是修饰符下面的
    def call():
        start = time.perf_counter()
        print("It's time starting ! ")
        func()  #实际调用了f函数 （func()是关键字一样）
        print("It's time ending ! ")
        end = time.perf_counter()
        return "It's used : %s ." % (end - start)  #输出打印
    return call

#通过 @timeslong 对其进行修饰达到目的，是整个代码美观，而且少些部分代码
@timeslong  #先执行 timelong 再调用执行 func => f()
def func():
    y = 0
    for i in range(5):
        y = y + i + 1
        print(y)
    return y

print(func())
######### 执行结果.START########
# It's time starting !
# 1
# 3
# 6
# 10
# 15
# It's time ending !
# It's used : 0.006445216000000031 .
######### 执行结果.END########


#案例3.修饰符也可以通过类来进行使用
class timeslong1(object):
    def __init__(self,func):
        self.f = func  #传入的实际是f() 函数

    def __call__(self):
        start = time.perf_counter()
        print("It's time starting ! ")
        self.f()
        print("It's time ending ! ")
        end = time.perf_counter()
        print("It's used : %s ." % (end - start))

@timeslong1  #将下面的函数或者类作为自己的参数
def f():
    y = 0
    for i in range(3):
        y = y + i + 1
        print(y)
    return y
 
f()  #调用时候触发@修饰符

######### 执行结果.START########
# It's time starting !
# 1
# 3
# 6
# It's time ending !
# It's used : 0.00160638099999999 .
######### 执行结果.END########
