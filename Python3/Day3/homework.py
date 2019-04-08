#设点 A(X1,Y1)、点 B(X2,Y2)，则两点构成的直线长度 |AB| = √((x1-x2)^2+(y1-y2)^2)
# Python 中计算开根号可使用 math 模块中的 sqrt 函数
# 直线需有两点构成，因此初始化时需有两个点（Point）对象作为参数

#!/usr/bin/python3
#方法1：继承
import math

class Point:
    #初始化坐标
    def __init__(self,x1=0,y1=0,x2=0,y2=0):
        self.X1 = x1
        self.X2 = x2
        self.Y1 = y1
        self.Y2 = y2

class Line(Point):
    msg = ''
    def __init__(self,msg,x1, y1, x2, y2):
        super().__init__(x1, y1, x2, y2)
        self.msg = msg
        print("坐标信息 (%d,%d), (%d,%d)" %(self.X1,self.Y1,self.X2,self.Y2))
    def getLen(self):
        print("当前Tips:%s,计算中....." %self.msg)
        return math.sqrt((self.X1 - self.X2) * (self.X1 - self.X2) + (self.Y1 - self.Y2) * (self.Y1 - self.Y2))

zhixian = Line('计算两点之间距离',1,1,4,5)
print(zhixian.getLen())

#方法2：传入对象类似于继承
class Point1():
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def getX(self):
        return self.x

    def getY(self):
        return self.y

class Line1():
    def __init__(self, p1, p2):
        self.x = p1.getX() - p2.getX()
        self.y = p1.getY() - p2.getY()
        self.len = math.sqrt(self.x*self.x + self.y*self.y)

    def getLen(self):
        return self.len


