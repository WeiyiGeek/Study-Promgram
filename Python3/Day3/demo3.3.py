#!/usr/bin/python3
#功能：
import random as r

class Fish:
    def __init__(self):
        self.x = r.randint(0,10)
        self.y = r.randint(0,10)
    
    def move(self):
        self.x -= 1
        print("我得位置是：",self.x,self.y)


class Shark(Fish):
    def __init__(self):
        super().__init__()        #方法1：只需要传入父类即可
        #Fish.__init__(self)    #方法2: 调用类狗构造方法
        self.hungry = True
    def eat(self):
        if self.hungry:
            print("饿了,要吃饭@！")
            self.hungry = False
        else:
            print("太撑了,吃不下了")


demo = Fish()
demo.move()

demo1 = Shark()
demo1.eat()
demo1.eat()


#/***多重继承（继承）**/#
class Base1:
    def printf1(self):
        print("Base1: 父类")

class Base2:
    def printf2(self):
        print("Base2: 父类")


class Pool(Base1,Base2):
    def child(self):
        print("我是子类")

tt = Pool()
tt.child()
tt.printf1()
tt.printf2()


#****类得组合（横向）***#
class Turtle:
    def __init__(self,x):
        self.num = x

class Fishe:
    def __init__(self, x):
        self.num = x

class Aini:
    def __init__(self, x, y):
        self.turtle = Turtle(x)
        self.fishe = Fishe(y)
    def print_num(self):
        print("水池里总共乌龟 %d 只,小鱼 %d 条" %(self.turtle.num,self.fishe.num))

demo3 = Aini(5,6)
demo3.print_num()

#类绑定
class CC:
    def setXY(self,x,y):
        self.x = x
        self.y = y
    def printXY(self):
        print(self.x,self.y)

dd = CC()   #实例化对象
dd.setXY(5,7)
del CC   #这里删除了定义CC类,但是实例化得dd对象并不会被销毁，而是在程序结束后进行释放
dd.printXY()    #任然可以打印    
