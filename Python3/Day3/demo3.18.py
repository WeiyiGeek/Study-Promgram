#!/usr/bin/python
#类属性 - 描述符

#定义一个类,为了实现原生的property原理必须使用下面的三个魔术方法
#案例1
class Decriptor:
    def __get__(self,instance,owner):
        print("getting ... ",self, instance, owner) #参数分别代表 (Decriptor本身类 , 类对象test , Test类本身)

    def __set__(self,instance,value):
        print("setting ... ",self, instance, value)

    def __delete__(self,instance):
        print("deleting ...",self,instance)        

class Test:
    x = Decriptor()  #Decriptor() 类的实例 / 又叫属性x的描述符

test = Test()
test.x
test.x = 'ceshi'
del test.x 

############ 执行结果 #######
# getting ...  <__main__.Decriptor object at 0x000002443D18E908> <__main__.Test object at 0x000002443D18E940> <class '__main__.Test'>
# setting ...  <__main__.Decriptor object at 0x000002443D18E908> <__main__.Test object at 0x000002443D18E940> ceshi
# deleting ... <__main__.Decriptor object at 0x000002443D18E908> <__main__.Test object at 0x000002443D18E940>


#案例2：自定义property
class MyProperty:
    def __init__(self, fget=None, fset=None,fdel=None):  #其他类的三个方法
        self.fget = fget
        self.fset = fset
        self.fdel = fdel

    def __get__(self,instance,owner):
        return self.fget(instance)      #传入实例对象的方法

    def __set__(self,instance,value):
        self.fset(instance,value)
    
    def __delete__(self,instance):
        self.fdel(instance)


class C:
    def __init__(self):
        self._x = None
    
    def getX(self):
        return self._x

    def setX(self, value):
        self._x = value

    def delX(self):
        print("delete 销毁属性!")
        del self._x
    
    #x 对象的描述符 （传入类里面的三个方法）
    x = MyProperty(getX,setX,delX)   #类实例

c = C()
c.x = 'Property'
print(c.x,c._x)
del c.x

######################
# Property Property
# delete 销毁属性!
