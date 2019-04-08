#!/usr/bin/python
#功能：类与对象的内置BIF

class t1:
  pass
class t2(t1):
  noneValue = None  #为空值,相当于C中的null
  def __init__(self,x=0):
    self.x = x
print(issubclass(t2,t1))  #t2 是 t1 的子类为真
test = t2(1024)
print(isinstance(test,t1))  #为真的实例化对象test是t1实例化对象

#16.hasattr
print(hasattr(test,'x'))  #‘x’是test对象的属性

print(getattr(test,'x'))
print(getattr(test,'e','没有实例化对象中没有 e 属性'))

setattr(test,'e','Hello world')
print(getattr(test,'e','实例化对象中没有 e 属性')) #hello world


class getSize:
    def __init__(self,size = 0):
        self.size = size
    def getsize(self):
        return self.size
    def setsize(self,value):
        self.size = value
    def delsize(self):
        del self.size
    
    x = property(getsize,setsize,delsize) #包含该类建立得一些方法 (此时x是一个属性)

demo = getSize(1024) #实例化对象
print(demo.x)  #利用属性获取方法返回值
demo.x = 2048  #利用属性设置方法值
print(demo.x)  #获取值
del demo.x     #删除值 

        