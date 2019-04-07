#!/usr/bin/python3
#魔术：方法

#案例2：
class Count:
    count = 0 
    def __init__(self):    #实例 初始化
        Count.count += 1
    def __del__(self):     #del 调用触发 该魔术方法
        Count.count -= 1
    def getCount(self):
        print("当前 count 的 %d 值" %Count.count)

a = Count() #触发init
b = Count()
c = Count()
print(Count.count)
del a  #触发del
print(Count.count)
