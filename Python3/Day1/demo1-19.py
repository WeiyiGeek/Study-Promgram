#!/usr/bin/python3
#功能：集合内置函数

set1 = {1,2,3,5,6,7}
set2 = {7,11,9,10}
set1.add(8)  #添加集合元素
print("添加元素：",set1)  #添加元素： {1, 2, 3, 5, 6, 7, 8}
set1.update(set2)  #可以直接添加集合到 目标集合中
print("update：",set1)  #update： {1, 2, 3, 5, 6, 7, 8, 9, 10, 11}


set1 = set2.copy()  #拷贝集合
print("拷贝：",set1)    #拷贝： {9, 10, 11, 7}

print("pop 移除:",set2.pop())  #随机移除元素  pop 移除: 9
set2.remove(11)  #移除指定元素,元素不存在报错
set2.discard(10)  #移除指定元素，元素不存在不报错
print("remove：",set2)  #remove： {7}

set2.clear()  #清空集合
print("清空：",set2)    #清空： set()

#差集
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.difference(y)  #即返回的集合元素包含在第一个集合中，但不包含在第二个集合(方法的参数)中。
print(z)  #{'cherry', 'banana'}

x.difference_update(y)  #移除两个集合都包含的元素
print("差集",x)  #差集 {'cherry', 'banana'}

#交集
x = {1,4,6}
y = {2,1,7}
z = x.intersection(y)
print("交集",z)   #交集 {1}

#并集
z = x.union(y)
print("并集：",z) #并集： {1, 2, 4, 6, 7}

#亦或集（两个集合中都不存在的集合）
z = x.symmetric_difference(y)
print("异集：",z)

#判断是否为子集
print({"a", "b", "c"}.issubset({"f", "e", "d", "c", "b", "a"})) #判断集合 x 的所有元素是否都包含在集合 y 中
print({"f", "e", "d", "c", "b", "a"}.issuperset({"a", "b", "c"}))#判断集合 y 的所有元素是否都包含在集合 x 中

#判断两个集合是否包含相同的元素
print("集合相同与否：",x.isdisjoint(y))
