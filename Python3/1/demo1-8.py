#!/usr/bin/python3
#coding:utf-8
#功能:Dictionary 字典类型 是一个 Key与Value,与set集合都使用{}来标识

createdict = {}
createdict['one'] = "1 - Python3"
createdict['two'] = "2 - Version 3.7.2"
tinydict = {'name':"weiyigeek",'age':21,'love':"Python3 PHP html5 JAVASCRIPT"}

print(createdict)  #输出字典值/value
print(createdict['one']) #输出键为 'one' 的值
print(tinydict.keys()) #输出所有键
print(tinydict.values(),end="\n\n") #输出所有值


#构造函数 dict() 可以直接从键值对序列中构建字典
cdict1 = dict([('Runoob', 1), ('Google', 2), ('Taobao', 3)])  #方式1
cdict2  = dict(Runoob=1, Google=2, Taobao=3)                  #方式2
jiecheng = {x: x**2 for x in (2, 4, 6)}   #可以直接进行幂乘 (值得学习)
print(cdict1)
print(cdict2)
print(jiecheng)
