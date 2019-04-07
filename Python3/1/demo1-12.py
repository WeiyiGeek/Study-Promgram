#!/usr/bin/python3
#coding:utf-8
#功能：列表类型详解

#V1.创建普通列表
L=['Google', 'Runoob', 'Taobao']

#V2.创建混合列表(嵌套的列表)
mix = [1,'list0',2.3,[1,2,3]]

#V3.创建空列表
empty = []


#更新列表 （也可以交换数组）
print("L[1]列表修改前：",L[1],end=" ")
L[1] = 'Weiyigeek'
print("修改后：",L[1],end="\n")

#删除列表元素
del L[2]
print ("删除L[2]后的列表 : ", L)

#列表长度
print (len(L))

#列表组合
print(L+[1,2,3])

#列表重复
print(L * 2)

#判断是否处于列表中
print('Weiyigeek' in L)

#迭代
for x in range(len(L)):
    print(x,L[x],len(L[x]))

#嵌套列表 类似于二维数组
print(mix[3][1])  #输出2

list1 = [(x,y) for x in range(10) for y in range(10) if x % 2 == 0 if y % 2 != 0] #x能整除的2，而y不能整除2进行显示（x.y）
print(list1)
#[(0, 1), (0, 3), (0, 5), (0, 7), (0, 9), (2, 1), (2, 3), (2, 5), (2, 7), (2, 9), (4, 1), (4, 3), (4, 5), (4, 7), (4, 9), (6, 1), (6, 3), (6, 5), (6, 7), (6, 9), (8, 1), (8, 3), (8, 5), (8, 7), (8, 9)]
#等价于下面
list2 = []
for x in range(10):
    for y in range(10):
        if  (x % 2 == 0) & (y % 2 !=0):
            list2.append((x,y))
print(list2)

#列表解析进阶
list1 = ['1.Jost do it','2.一切皆有了能','3.让编程改变世界']
list2 = ['2.李宁','3.鱼C工作室','1.Nick']
list3 = [name+':'+title[2:] for title in list1 for name in list2 if name[0] == title[0]]  #采用列表解析的方式进行 当for循环首字符变例一致的时候输出
print(list3)  #['1.Nick:Jost do it', '2.李宁:一切皆有了能', '3.鱼C工作室:让编程改变世界']


