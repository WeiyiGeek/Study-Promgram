#!/usr/bin/python3
# coding:utf-8
# 功能：迭代器与生成器
import sys  # 引入 sys 模块
list = [1, 2, 3, 4]
it = iter(list)
#***方法1 for**#
for x in it:
    print("值", x, end=", ")
else:
    print("\n---------------------------")


#***方法3 迭代器类**#
# //创建一个返回数字的迭代器，初始值为 1，逐步递增 1：
class MyNumbers:
    def __iter__(self):
        self.a = 1
        return self

    def __next__(self):
        if self.a <= 3:
            x = self.a
            self.a += 1
            return x
        else:
            raise StopIteration


myclass = MyNumbers()
myiter = iter(myclass)
print(next(myiter), end="|")  #实际运行了两次
print(next(myiter))


it = iter(list)
#***方法2 next**#
while True:
    try:
        print(next(it), end=",")
    # StopIteration 异常用于标识迭代的完成，防止出现无限循环的情况;
    except StopIteration:
        sys.exit()
