#!/usr/bin/python3
#coding:utf-8
#功能：元组tuple 戴上了枷锁的列表

tup = (1,2,3,4)  #定义一个元组
temp = 1,2,3,4   #另外一钟方法也能定义一个元组(值得学习)
print("类型：",type(temp))  #类型： <class 'tuple'>
print("tuple创建：",8 * (8,)) #(两种方式必须有逗号)  tuple创建： (8, 8, 8, 8, 8, 8, 8, 8)
print("切片：",temp[1:3])  #切片slice(也可以利用此来拷贝元组) 切片： (2, 3)

temp = ('小明','小经','小陈','小郑')
temp = temp[:2] + ('郑老师',) +temp[2:] #利用切片方式分成两段加入新elements再拼接,注意逗号和类型. #拼接的元组： ('小明', '小经', '郑老师', '小陈', '小郑')
print("拼接的元组：",temp)
del temp #面向对象的编程语言就有回收机制
print(tup * 2)   #(1, 2, 3, 4, 1, 2, 3, 4)
L = ('Google', 'Taobao', 'Runoob')
print("{0} , {1} , {2}".format(L[-1],L[1],L[0]))  #格式化输出元组  Runoob , Taobao , Google