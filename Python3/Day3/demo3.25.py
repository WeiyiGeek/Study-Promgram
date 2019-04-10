#!/usr/bin/python3
#功能：容器序列定制类型协议()
# -*- coding:utf-8 -*-
class Countnum:
    def __init__(self,*args):
        self.value = [x for x in args]  #列表表达式
        self.count = {}.fromkeys(range(len(self.value)),0)

    def __len__(self):
        return len(self.value)

    def __getitem__(self,index):
        self.count[index] += 1
        return self.value[index]

a = Countnum(1,3,5,7,9)
b = Countnum(2,4,6,8,10)

print(a[1],b[1])
print(a[1],b[1])
print("两个对象数列之和：",a[3]+b[3])

print("A对象访问的次数：",a.count)
print("B对象访问的次数：",b.count)
