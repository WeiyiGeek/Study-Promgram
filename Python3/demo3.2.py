#!/usr/bin/python3
#功能：Python对象编程学习

# #/***类封装**/#
# class Person:
#     name = 'Weiyigeek'
#     age = 20
#     msg = 'I Love Python'
#     def detail(self):
#         print('姓名 ：',self.name,"年龄：",self.age, "爱好:",self.msg)

# oop = Person()
# oop.detail()

# #/***类继承**/#
# class mylist(list):
#     pass

# list2 = mylist()
# list2.append(10)  #继承了list类得方法
# list2.append(2)
# list2.append(3)
# list2.sort()    #继承了list类得方法
# print(list2)


# #/***类多态**/#
# class A:
#     def fun(self):
#         print("我是小A....")
# class B:
#     def fun(self):
#         print("我是小B....")

#self 方法得使用
class selfdemo:
    def __init__(self,name):
        self.name = name
    def demo1(self,name):
        self.name = name

    def demo2(self):
        print("我是 %s 得对象" %self.name)

a = selfdemo("Weiyigeek")
a.demo1("Weiyigeek")
b = selfdemo("Weiyigeek")
b.demo1("Python")
a.demo2()
b.demo2()

#___init___(self)
#私有函数
class Person1:
    __name = 'Weiyigeek' #类得私有变量
    def getpri(self):
        return self.__name

tt = Person1()
print("类私有变量变量得输出",tt.getpri())

调用未绑定得父类方法,使用super函数
