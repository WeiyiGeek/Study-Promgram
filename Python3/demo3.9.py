#!/usr/bin/python3
class Test:
    public_attrs = 0 #公共属性
    __private_attrs = 0 #私有
    def prt(self):
        print('这是公共方法')  # 公共方法
        print(self)
        print(self.__class__)
        self.__foo()   #调用私有方法

    def __foo(self):          # 私有方法
        print('这是私有方法')
        
t = Test()
t.prt()

# 注意 #
t._Test__private_attrs  #掉用私有属性
t._Test__foo()