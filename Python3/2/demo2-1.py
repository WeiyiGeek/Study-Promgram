#!/usr/bin/python3
#功能：生成器yield
#coding:utf-8
import sys
 
def fibonacci(n): # 生成器函数 - 斐波那契
    a, b, counter = 0, 1, 0
    while True:
        #当 counter == 10 结束（即算出10次数）
        if (counter > n): 
            return
        yield a  #生成器进行返回
        a, b = b, a + b
        counter += 1
f = fibonacci(10) # f 是一个迭代器，由生成器返回生成
 
while True:
    try:
        print(next(f), end=" ")
    except StopIteration:
        sys.exit()

