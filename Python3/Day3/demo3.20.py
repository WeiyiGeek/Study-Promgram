#!/usr/bin/python3
#[扩展阅读] 如何使用静态方法、类方法或者抽象方法

#1.Python 方法的运作
class Pizza(object):
    def __init__(self, size):
        self.size = size
    def get_size(self):
        return self.size

print(Pizza.get_size)  #Python3中 归属于一个类的函数不再被看成未绑定方法（unbound method），但是作为一个简单的函数(返回函数地址)
                       #Python2中 类Pizza的属性get_size是一个非绑定的方法

print("Pizza类地址：",Pizza(12).get_size)    #实例化对象与方法绑定,在 Python3 中bound原理是一样的，模型被简化了
print("get_size() 获取方法后值：",Pizza(12).get_size())  #实例化对象调用get-size方法

## 但是如何知道已绑定的方法被绑定在哪个对象上？技巧如下：
m = Pizza(42).get_size
print("Pizza对象",m.__self__,"\nPizza对象get_size方法地址即是bound method Pizza.get_size 类地址：",m == m.__self__.get_size)

############################## 执行结果 #######################################
# <function Pizza.get_size at 0x000002BF0D9C9598>
# Pizza类地址： <bound method Pizza.get_size of <__main__.Pizza object at 0x000002BF0D9F2978>>
# get_size() 获取方法后值： 12
# Pizza对象 <__main__.Pizza object at 0x000002BF0D9F2978>
# Pizza对象get_size方法地址即是bound method Pizza.get_size地址： <bound method Pizza.get_size of <__main__.Pizza object at 0x000002BF0D9F2978>>


#2.静态方法
# 静态方法避免了这样的情况：
# - 降低了阅读代码的难度：看到 @staticmethod 便知道这个方法不依赖与对象本身的状态；
# - 允许我们在子类中重载mix_ingredients方法。
# 如果我们使用在模块最顶层定义的函数 mix_ingredients，一个继承自 SPizza 的类若不重载 cook，可能不可以改变混合成份（mix_ingredients）的方式。

class SPizza(object):
    @staticmethod   #@ 修饰器 
    def mix_ingredients(x, y):
        return x + y
    
    #将方法 mix_ingredients 作为一个非静态的方法也可以 work，但是给它一个 self 的参数将没有任何作用。
    def cook(self):  
        return self.mix_ingredients(self.cheese, self.vegetables)

print(SPizza().mix_ingredients(1,2))  # 3 
print(SPizza.cook is SPizza().cook)  # False 是因为前者是 类的方法  后者是实例化对象的方法嘛，

# >>> Pizza().mix_ingredients is Pizza().mix_ingredients
# True
# >>> Pizza().mix_ingredients is Pizza.mix_ingredients
# True

# >>> Pizza()
# <__main__.Pizza object at 0x10314b410>



#3.类方法
#类方法一般用于下面两种：
#- 工厂方法，被用来创建一个类的实例，完成一些预处理工作,如果我们使用一个 @staticmethod 静态方法，我们可能需要在函数中硬编码 Pizza 类的名称，使得任何继承自 Pizza 类的类不能使用我们的工厂用作自己的目的。
class Pizza(object):
    def __init__(self, ingredients):
        self.ingredients = ingredients

    @classmethod #类方法
    def from_fridge(cls, fridge):
        return cls(fridge.get_cheese() + fridge.get_vegetables())

#- 静态方法调静态方法：如果你将一个静态方法分解为几个静态方法，你不需要硬编码类名但可以使用类方法
class Pizza(object):
 def __init__(self, radius, height):
     self.radius = radius
     self.height = height

 @staticmethod  #静态方法
 def compute_circumference(radius):
      return math.pi * (radius ** 2)

 @classmethod  #类方法
 def compute_volume(cls, height, radius):
      return height * cls.compute_circumference(radius)  #可以调用静态方法

 def get_volume(self):
     return self.compute_volume(self.height, self.radius)


#4.抽象方法
class Pizza(object):
 def get_radius(self):
     raise NotImplementedError  #任何继承自 Pizza 的类将实现和重载 get_radius 方法，否则会出现异常。

# >>> Pizza()
# <__main__.Pizza object at 0x106f381d0>

# >>> Pizza().get_radius()
# Traceback (most recent call last):
# File "<stdin>", line 1, in <module>
# File "<stdin>", line 3, in get_radius
# NotImplementedError

#有种提前引起错误发生的方法，那就是当对象被实例化时，使用 Python 提供的 abc 模块。
import abc
class BasePizza(object):
 __metaclass__ = abc.ABCMeta

 @abc.abstractmethod
 def get_radius(self):
     """Method that should do something."""
# 使用 abc 和它的特类，一旦你试着实例化 BasePizza 或者其他继承自它的类，就会得到 TypeError：
# >>> BasePizza()
# Traceback (most recent call last):
# File "<stdin>", line 1, in <module>
# TypeError: Can't instantiate abstract class BasePizza with abstract methods get_radius

