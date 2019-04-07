#!/usr/bin/python
#递归求出二进制
listbin = []
def binary(x):
    if x != 1:
        binary(x // 2)
        return listbin.append(x % 2)
    else:
        return listbin.append(1)

value = input("输入一个整形值:")
value = int(value)
binary(value)
for each in listbin:
    print(each,end="")
else:
    print("")