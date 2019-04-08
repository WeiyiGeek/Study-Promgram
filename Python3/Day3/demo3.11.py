#!/usr/bin/python3
#功能：魔术方法

#CapStr 继承一个 不可变得 类
class CapStr(str):
    def __new__(cls,string):
        string = string.upper()
        return str.__new__(cls,string) #返回修改后得字符给对象

a = CapStr('I love Study Python3!')
print(a)

#继承 int 类
class Newint(int):
    def __add__(self, value):
        return super().__add__(value)  #super是超类指代父类
    def __sub__(self, value):
        #return super().__sub__(value) #方法1
        return int(self) - int(value)  #方法2,注意这里必须要强制类型转换,如过向以下则会报错递归循环异常
        #return self - value   #RecursionError: maximum recursion depth exceeded in comparison
    def __and__(self, value):       #该魔术方法  = &  
        return super().__and__(value)

a = Newint(7)
b = Newint(6)
print("a + b =",a + b)
print("a - b =",a - b)
print("a & b =",a & b)
