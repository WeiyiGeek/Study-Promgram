#!/usr/bin/python3
#实例化对象和类型

#案例1：封装特性
class Person:
    name = 'WeiyiGeek'    #属性
    age = 20
    msg = 'I Love Python'
    __weight = 0  #私有变量
    def printname(self):  #方法
        print(self.name,self.age,self.msg,self.__weight)

people = Person()   #实例化
people.printname()  #对象.方法
print(people._Person__weight)

#案例2：封装特性
class Rectangle:
    length = 5
    width = 6
    #设置长宽
    def setRect(self,length,width):
        self.length = length
        self.width = width
    
    #获取长宽
    def getRect(self):
        print("矩形的长宽为：%d , %d" %(self.length,self.width))
    
    #获取面积
    def getArea(self):
        print("矩形面积 =",self.width * self.length)

    #获取周长
    def getGirth(self):
        print("矩形周长 =",2 * (self.width + self.length))

rect = Rectangle()
rect.setRect(15,16)
rect.getRect()
rect.getArea()
rect.getGirth()