#!/usr/bin/python3
#功能：super 超类的实现
import random as r  #别名

class Fish:
    def __init__(self):
        self.x = r.randint(0,10)
        self.y = r.randint(0,10)
    
    def move(self):
        self.x -= 1
        print("我得位置是：",self.x,self.y)

class Shark(Fish):
    def __init__(self):
        super().__init__()        #方法1：只需要设置super() 指代 父类
        #Fish.__init__(self)      #方法2: 调用父类构造方法
        self.hungry = True
    def eat(self):
        if self.hungry:
            print("饿了,要吃饭@！")
            self.hungry = False
        else:
            print("太撑了,吃不下了")

demo1 = Shark()
demo1.move()
demo1.eat()
demo1.eat()
demo1.move()
