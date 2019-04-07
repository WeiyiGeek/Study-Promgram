#!/usr/bin/python3
def fun1():
    x = 5
    def fun2():
        nonlocal x
        x *= 2
        return x
    return fun2   #注意这里没有括号

demo = fun1()
print(demo())
print(demo())
print(demo())
print(demo())



