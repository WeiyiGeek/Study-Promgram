#!/usr/bin/python3
#min 内置函数的实现 与 sum bug 解决

def min(x):
    initvalue = x[0]
    for each in x:
        if each < initvalue:  #实际采用的ASCII进行比对的
            initvalue = each
    else:
        print("计算成功")
    return initvalue

print(min('178546810'))

def sum(x):
    result = 0
    for each in x:
        if isinstance(each,int) or isinstance(each,float):
            result += each
        
    return result;
print(sum([1,3,6.6,'y',"abcd"]))