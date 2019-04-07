#!/usr/bin/python3
#补充魔术方法

class Demo:
    def __str__(self):
        return '我是__str__魔术方法,需要print()输出'
    
class Demo1:
    def __repr__(self):
        return '2 - 我是__repr__魔术方法,直接对象输出'
  
a = Demo()
print("1 -",a)

b = Demo1()
print(b)  #在>>> b 可以直接输出
