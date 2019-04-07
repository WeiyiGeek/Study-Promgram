#!/usr/bin/python3
#coding:utf-8
#功能:验证Tuple元组

tuple1 = ('abc',789,2.23,'WEIYIGEEK',70.2)
pjtuple = ('Python','Version 3.7.2')

print(tuple1[1:3])       #从下标索引为1到下标索引为2的元素打印出来(注意元素的个数 3 -1 = 2)
print(pjtuple * 2)       #重复
print(tuple1 + pjtuple)  #拼接

#构造包含 0 个或 1 个元素的元组比较特殊
tup1 = ()    # 空元组
tup2 = (20,) # 一个元素，需要在元素后添加逗号
print("空元组",tup1)
print("一个元素",tup2)
