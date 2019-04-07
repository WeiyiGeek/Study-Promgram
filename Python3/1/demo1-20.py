#!/usr/bin/python3
#coding:utf-8
#功能：字典内置函数
dict1 = {"one":'weiyigeek',"two":"tterdst"}
dict2 =dict.fromkeys(('name','age'),'weiyigeek')
print("字典：",str(dict1),"类型:",type(dict1))
print("建立字典：",str(dict2))

print("姓名：",dict1.get('one'))
print("未知：",dict1.setdefault('three',"ValueNULL"))

print("Key :",list(dict1.keys()))
print("Value :",list(dict1.values()))
print("dict :",dict1.items()) #dict_items([('one', 'weiyigeek'), ('two', 'tterdst'), ('three', 'ValueNULL')])

dict1.update({'four':'update'}) #添加键值对
print("添加键值对：",dict1) #{'one': 'weiyigeek', 'two': 'tterdst', 'three': 'ValueNULL', 'four': 'update'}

print("pop('one') :",dict1.pop('one'))  #删除指定key与值并返回值 weiyigeek
print("popitem() :",dict1.popitem())  #删除末尾key ('four', 'update')

dict2.clear()
print("清空字典：",dict2)  #清空字典： {}

#成员运算符
print("判断键是不是在字典中：",'two' in dict1)  #判断键是不是在字典中： True