#!/usr/bin/python
# -*- coding:UTF-8 -*-
# 功能：time模块的使用

import time as t  

print("####sleep - 延迟3s执行！###")
#t.sleep(3)

#把一个格式化时间字符串转化为 struct_time 
print(t.strftime("%a %b %Y %H:%M:%S +0000", t.localtime()))
print(t.strftime("%A %B %Y %H:%M:%S +0000", t.gmtime()))

# 接受时间元组并返回一个可读的形式
print("asctime() ",t.asctime(t.localtime()))

# 作用相当于 asctime(localtime(secs))，未给参数相当于 asctime()
print("ctime() ",t.ctime())

# 接受时间元组并返回时间辍
print("mktime() 指定时间的时间戳",t.mktime(t.localtime()))

# 返回当前时间的时间戳（1970 纪元年后经过的浮点秒数）
print("time() 当前时间戳 :",t.time()) 

# 当地时区（未启动夏令时）距离格林威治的偏移秒数（美洲 >0；大部分欧洲，亚洲，非洲 <= 0）
print("timezone 距离格林威治的偏移秒数 :",t.timezone)

#返回格林威治西部的夏令时地区的偏移秒数
print("altzone 返回格林威治西部的夏令时地区的偏移秒数 :",t.altzone)

# 返回计时器的精准时间（系统的运行时间）
print("perf_counter() 计时器的精准时间 ",t.perf_counter())

#返回当前进程执行 CPU 的时间总和，不包含睡眠时间
print("process_time() 当前进程执行 CPU 的时间总和",t.process_time())

#包含两个字符串的元组：第一是当地非夏令时区的名称，第二个是当地的 DST 时区的名称。
print(t.tzname)  #乱码


