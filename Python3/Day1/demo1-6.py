#!/usr/bin/python3
#coding:utf-8
#功能:验证set 集合 (区分大小写)

student = {"weiyigeek","WEIYIGEEK","陶海鹏","郑老狗","陈挥铭",'WEIYIGEEK'}
print(student) # 输出集合(随机排序)，重复的元素被自动去掉

#成员测试
if 'weiyigeek' in student:
    print("weiyigeek 存在!")
else:
    print("不存在!")

# set 可以进行集合运算
a = set('abracadabra')
b = set('alacazam')

# 下面运算是值得学习的 集合可以进行 差集
print(a - b)     # a 和 b 的差集
print(a | b)     # a 和 b 的并集
print(a & b)     # a 和 b 的交集
print(a ^ b)     # a 和 b 中不同时存在的元素

