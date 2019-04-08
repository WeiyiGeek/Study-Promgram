#!/usr/bin/python3
#温湿度类实现：摄氏度,华氏度

#摄氏度类
class Celsius:
    #初始化构造方法
    def __init__(self,value = 26.0):
        self.value = float(value)

    def __get__(self,instance,owner):
        return self.value

    def __set__(self,instance,value):
        self.value =float(value)

#华氏度类
class Fahrenheit:
    def __get__(self,instance,owner):
        return instance.cel * 1.8 + 32            #返回华氏度 关键点

    def __set__(self,instance,value):
        instance.cel = (float(value) - 32) / 1.8  #返回摄氏度  关键点

#温度类
class Tempareture:
    cel = Celsius()     #摄氏度类
    fah = Fahrenheit()  #华氏度类


temp = Tempareture()
temp.cel = 37.5                                              #进行赋值的时候 cel 对象 value 属性 = 37.5
print("摄氏度 ：%.2f  , 华氏度 ：%.2f" %(temp.cel,temp.fah))  #temp.fah 进行请求触发 华氏度类 __get__  => 返回华氏度的计算后的值
temp.fah = 75.0
print("摄氏度 ：%.2f  , 华氏度 ：%.2f" %(temp.cel,temp.fah))


############ 执行结果 #############
# 摄氏度 ：37.50  , 华氏度 ：99.50
# 摄氏度 ：23.89  , 华氏度 ：75.00
