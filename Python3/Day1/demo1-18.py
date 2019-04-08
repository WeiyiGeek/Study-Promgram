#!/usr/bin/python3
#功能：集合set

set1 = {'weiyi','geek',12.345}
set2 = set("Python")
print(type(set1),set1)  #输出无序
print(type(set2),set2)  #输出无序

print(set1-set2)   #类似列表推导式，同样集合支持集合推导式(Set comprehension)  #{'geek', 'weiyi', 12.345}
a = {x for x in 'abcasdsadsa' if x not in 'abc'}  # {'d', 's'} 
print(a) #集合支持集合推导式(Set comprehension)
tuple1 = (1.1,2.2,3.3,ord('a'))  #必须是同一类型
print(sum(tuple1))      # 6.6

print(sorted([23,56,2,16,96,12,14]))
temp = [23,56,2,16,96,12,14]
print(list(reversed(temp)))
print(list(enumerate([23, 56, 2, 16, 96, 12, 14])))
print((1,2.3,4))