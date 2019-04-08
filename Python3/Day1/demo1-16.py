#!/usr/bin/python
#功能：获取列表内置方法
dir(list)  #查看内置方法

member = ['list1','list2','list3']
print("列表长度：",len(member))

#列表是一个大杂缸可以进行比较 可以进行一些 常用操作符
list1 = [123]
list2 = [234]
print(list1 > list2) #进行逻辑判断
list3 = [234]
print((list1 < list2) and (list2 == list3))  #进行逻辑判断


#列表添加方法
member.insert(0,'0insert') #头部插入    //member是对象,append()是对象的一个方法
member.insert(2,'2insert') #指定位置插入
member.extend(['list3','list4']) #从新建立的一个列表中添加到另外一个列表中，所以extend()中的数据必须是列表.
member.append(['4apped1','4apped2']) #尾部插入列表
print(member)

#列表删除元素
member.remove('2insert') #不需要知道位置,只需要知道list中的元素数据
del member[0] #加上列表的索引就删除该索引上的元素,加上列表对象就删除该列表.
print(member.pop()) #列表利用栈这个数据结构进行存储,因此有了pop()方法进行弹栈,默认从列表中取出最后一个元素给你
member.pop(2)  #还可以加入索引值，进行弹栈 
print(member,end="\n\n")

print(member.count('list3')) #统计元素出现次数
print(member.index('list2')) #元素索引,根据元素来搜索索引下标

member.reverse()  #列表重新排序
print(member,end="\n\n")

#采用sort按照指定的方式进行排序
#sort(func[指定排序的算法],key[与算法搭配的关键字])  => 默认算法归并排序
list1 = [4,8,10,58,2,6]
list1.sort()
print(list1)
list1.sort(reverse=True)  #或者直接采用reverse=True   列表中的元素必须是同一类型
print(list1)

#清空与复制列表
list2 = member.copy()
print(list2) #复制列表
list2.clear() #清空列表返回 []
print(list2)