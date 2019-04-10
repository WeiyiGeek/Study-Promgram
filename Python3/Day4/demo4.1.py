#/usr/bin/python3
#导入外部模块验证

## 项目结构
# Day4
# │  demo4.1.py
# │  TemperatureConversion.py

########### 案例1 ##############
#方法1：import TemperatureConversion
#方法2：from TemperatureConversion import c2f,f2c #导入指定模块(不用考虑namespace)
#方法3：from TemperatureConversion import *    #不建议此种方法(可能导致命名空间混乱)
#方法4：如下（经常）
import TemperatureConversion as Temp

print("32 摄氏度 = %.2f华氏度" %Temp.c2f(32))
print("99 华氏度 = %.2f摄氏度 " %Temp.f2c(99))

########### 案例2 ##############
print(Temp.__name__) #显示的是模块名称

############# 执行结果 ###############
# 32 摄氏度 = 89.60华氏度
# 99 华氏度 = 37.22摄氏度
# TemperatureConversion