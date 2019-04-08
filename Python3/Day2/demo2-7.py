#!/usr/bin/python3
#功能：全局变量作用域和非全局作用域

"""global"""
num = 1
def fun1():
    global num  # 需要使用 global 关键字声明
    print("global:",num,end=",") 
    num = 123
    print(num,end=",")
    num += 133
fun1()
print(num)


"""nonlocal"""
def outer():
    num = 10
    def inner():
        nonlocal num   # nonlocal关键字声明
        num = 100
        print("nonlocal:",num,end=" | ")
        num *= 10.24
    inner()
    print(num,end=" | ")
outer()
print(num)  #这里的num没有变化由于outer函数中没有使用global关键字