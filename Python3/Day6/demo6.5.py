#!/usr/bin/python

class MyDes:
        def __init__(self, value = None):
                self.val = value
        def __get__(self, instance, owner):
                return self.val ** 2

class Test(MyDes):
        x = MyDes(3)

test = Test()
print(test.x)