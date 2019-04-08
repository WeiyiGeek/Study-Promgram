#!/usr/bin/python
#属性访问的魔法方法

#方法案例1：
class AttrView:
    def __getattribute__(self, name):
        print("调用 getattribute 魔法方法")
        return super().__getattribute__(name)  #super()自动获取基类，这个类没有继承类默认是object类

    def __getattr__(self,name):
        print('调用 getattr 魔法方法')

    def __setattr__(self,name,value):
        print("调用 setattr 魔法方法")
        super().__setattr__(name,value)
    
    def __delattr__(self, name):
        print('调用 delattr 魔法方法')
        super().__delattr__(name)

demo = AttrView()
demo.x  #尝试不存在属性的时候触发 调用 getattribute / getattr(不存在触发) 魔法方法
setattr(demo,'x',1) #设置属性 调用 setattr 魔法方法
demo.y = 1        #设置属性 调用 setattr 魔法方法
demo.y            #获取属性  调用 getattribute 魔法方法
delattr(demo,'y')  #删除属性  调用 delattr 魔法方法


#方法案例2：
class Rectangle:
    def __init__(self, width = 0, height = 0):
        self.width = width   #会触发__setattr__魔术方法
        self.height = height

    def __setattr__(self, name, value):
        if name == 'square':  #正方形
            self.height = value
            self.width = value
        else:
            super.__setattr__(self, name, value)   # 方法1：防止无限递归错误 (建议采用基类的setattr方法)
            #self.__dict__[name] = value    # 方法2 

    def getArea(self):
        return self.width * self.height

    def getPeri(self):
        return (2 * (self.width) +  2 * (self.height))

r1 = Rectangle(4,5)
print("矩形面积：",r1.getArea())

r1.square = 10 #建立一个属性表明是正方形
print("正方形面积: ",r1.getArea())
print("正方形周长：",r1.getPeri())
print("__dict__",r1.__dict__)    #将类的全部属性放返回字典类型