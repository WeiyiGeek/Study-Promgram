#!/usr/bin/python3
#功能：实现 类方法 / 静态方法  / 类属性

class Hello(object):
    def __init__(self):
        pass

    #方式1.类方法
    @classmethod
    def print_hello(cls):
        print("方式1：调用类方法 print_hello()",)

    #方式2： 正是因为设置静态方法和类方法过于讨人吐槽，因此 Python 的作者才开发出了函数修饰符的形式替代。
    def foo(cls):
        print("方式2：调用类方法 foo()")
    # 将 foo() 方法设置为类方法
    foo = classmethod(foo)

    #方式3：静态方法 （注意这里的巨坑 self ）
    @staticmethod
    def static_hello(self):
        print("方式3：调用静态方法 static_hello",end = 'Value =')
        return self

Hello.print_hello() # classmethod 修饰过后，print_hello() 就变成了类方法，可以直接通过 Hello.print_hello() 调用，而无需绑定实例对象了。
Hello.foo()
print(Hello.static_hello(1),Hello.static_hello)

#用属性修饰符创建描述符”的方式实现
class C:
    def __init__(self, size=10):
        self.size = size
        
    @property   #关键点 类属性 / 绑定的属性是x
    def x(self):
        return self.size

    @x.setter  #
    def x(self, value):
        self.size = value

    @x.deleter
    def x(self):
        del self.size

demo = C()
print("获取属性的值：",demo.x)  #获取属性的值： 10
demo.x = 1024
print("获取更改后属性的值：",demo.x) #获取更改后属性的值： 1024
del demo.x