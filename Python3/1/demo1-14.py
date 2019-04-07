#!/usr/bin/python3
#coding:utf-8
#功能：随机数函数
import random  #载入模块

print(random.choice(range(0,10)))  #0~10随机 int
print(random.randrange(0,100))     #0~100随机数 int 
print(random.random())       #0~1 随机生成 0.47044481738738064 float
print(random.uniform(0,10))  #0~1 随机生成 13.47044481738738064 float
random.seed()   #随机数种子

list = [1,2,3,4,5,6]
print(list)
random.shuffle(list)  #将序列的所有元素随机排序
print(list)

