#!/usr/bin/python3
#迭代器的实现

#魔法方法案例(1)
class MyNumbers:
    def __iter__(self):  #魔法方法
        self.a = 0 
        return self

    def __next__(self):  #当
        try:
            if self.a <= 3:
                x = self.a
                self.a += 1
                return x
            else:
                raise StopIteration
        except StopIteration:
            return ('迭代结束')

myclass = MyNumbers()
myiter = iter(myclass)  # 实际触发了__iter__ 中 a = 0
print(next(myiter), end=" ")  #运行1次 next
print(next(myiter), end=" ")  #运行2次 next
print(next(myiter), end=" ")  #运行3次 next
print(next(myiter), end=" ")  #运行4次 next
print(next(myiter))  #第五次运行next由于条件(或抛出 StopIteration 退出迭代)

#案例二：采用魔法方法实现斐波那契数列
class Fibs:
    def __init__(self):
        self.a = 0
        self.b = 1

    def __iter__(self):
        return self   #返回它本身由于它自身就是迭代器

    def __next__(self):
        self.a, self.b = self.b,self.a + self.b
        return self.a   #a就是下一个斐波那契的值
    # def __next__(self):
    #     self.a, self.b = self.b,self.a + self.b
    #     if self.a > 10:
    #         raise StopIteration   #表示
    #     return self.a

fibs = Fibs()
for each in fibs:
    if each < 20: #返回
        print(each, end=" ")
    else:
        break


#######################
# $ python demo3.24.py
# 0 1 2 3 迭代结束
# 1 1 2 3 5 8 13