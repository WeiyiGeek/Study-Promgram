#!/usr/bin/python3
#功能：采用魔术方法实现定时器

import time as t

class MyTimer():
    def __init__(self):
        self.unit = ['年','月','日','时','分','秒']
        self.prompt = "未开始计时！"
        self.lasted = []
        self.start = 0
        self.stop = 0

    #值得学习的地方
    def __str__(self):
        return self.prompt
    __repr__ = __str__    #关键学习点

    def __add__(self,other):
        prompt = "总共运行了"
        result = []
        for index in range(6):
            result.append(self.lasted[index] + other.lasted[index])
            if result[index]:
                prompt += (str(result[index]) + self.unit[index])
        return prompt

    '''开始计时'''       
    def Start(self):    #注意：属性名与方法名相同的时候将被覆盖  
        self.start = t.localtime()
        self.prompt = "提示：请先调用 Stop() 停止计时"
        print("计时开始...")    


    '''停止计时'''
    def Stop(self):
        if not self.start:
            print("提示：请先调用 Start() 进行计时！")
        else:    
            self.stop = t.localtime()
            self.__calc()  #调用私有方法
            print("计时停止!")

    '''内部方法：计算运行时间'''
    def __calc(self):
        self.lasted = []
        self.prompt = '总共运行了'
        for index in range(6):
            self.lasted.append(self.stop[index] - self.start[index])
            if self.lasted[index]:
                self.prompt += (str(self.lasted[index]) + self.unit[index])

        #为下一轮设置初始化变量
        self.begin = 0
        self.end = 0

a = MyTimer()
b = MyTimer()

a.Start()
b.Start()

t.sleep(5)

a.Stop()
b.Stop()
print("a 对象", a," b 对象" ,b)
print(a + b)

######## 执行结果 #############
# 计时开始...
# 计时开始...
# 计时停止!
# 计时停止!
# a 对象 总共运行了5秒  b 对象 总共运行了5秒
# 总共运行了10秒