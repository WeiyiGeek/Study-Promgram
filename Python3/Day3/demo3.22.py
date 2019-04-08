#!/usr/bin/python3
# classmethod 修饰过后，print_hello() 就变成了类方法，可以直接通过 Hello.print_hello() 调用，而无需绑定实例对象了。

class Hello(object):
    def __init__(self,obj):
        pass

@classmethod
def print_hello(cls):
    print("Hello",end = " ")


Hello.print_hello()