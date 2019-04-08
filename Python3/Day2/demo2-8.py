#!/usr/bin/python3
#功能：递归汉诺塔

def haoni(n,x,y,z):
    if n == 1:
        print(x,'-->',z)
    else:
        haoni(n-1,x,z,y)   #前n-1从x移动到y上
        print(x,'-->',z)   #将最底下盘子从x移动到z上
        haoni(n-1,y,x,z)   #将y上的n-1盘中移动到z上

haoni(3,'a','b','c')
print(list('123456799'))
print(tuple([1,2,3,5]))

#冻结集合(使其不能正常添加与删除元素)
num = frozenset([1,2,3,4])
print(num)
print(type(num))
