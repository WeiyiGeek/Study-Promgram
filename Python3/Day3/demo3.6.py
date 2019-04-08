#!/usr/bin/python
# class t1:
#   def t1print(self):
#     print('t1')

# class t2:
#   def t2print(self):
#     print('t2')

# class t3(t1,t2):
#   pass

# print(t3.__bases__)

#采用字典的方式来扩展对象方法 （值得学习）
class PlugIn(object): #注意这里的参数
    def __init__(self):
        self._exported_methods = []
        
    def plugin(self, owner):   #owner 即 我们combine 实例化的对象
        for f in self._exported_methods:
            print("类方法名 ："+f.__name__," 类方法地址：",f)             #实际是AFeature/BFeature 方法名/方法地址地址
            owner.__dict__[f.__name__] = f                              #在实例化对象c的字典之中加入将其他类方法

    def plugout(self, owner):
        for f in self._exported_methods:
            del owner.__dict__[f.__name__]

#注意这里是扩展的Plugin类
class AFeature(PlugIn):
    def __init__(self):
        super(AFeature, self).__init__()                #使用超类进行父类初始化
        self._exported_methods.append(self.get_a_value) #初始化的时候讲本类的方法地址传入到父类的列表之中 （重点）

    def get_a_value(self):
        print("可以被调用 a feature.")

#注意这里是扩展的Plugin类
class BFeature(PlugIn):
    def __init__(self):
        super(BFeature, self).__init__()
        self._exported_methods.append(self.get_b_value)

    def get_b_value(self):
        print("可以被调用 b feature.")

class Combine:
  pass

c = Combine()
print("Plugin 中 owner 即是传入的 c 对象地址：",c)
AFeature().plugin(c)   #作为插件 将A类中方法通过插件 加入到 c 对象中
BFeature().plugin(c)   #同上
c.get_a_value()
c.get_b_value()
