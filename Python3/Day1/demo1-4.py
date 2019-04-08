#!/usr/bin/python3
#coding:utf-8
#功能:验证列表(LIST)
             #-4 , -3 , -2  , -1   ,0
createlist = [1,1.0,True,"WEIYIGEEK",'c']
pjlist = ['Python','Version 3']
print(createlist) #完整列表

print(createlist[0])   #输出列表第一个元素
print(createlist[1:3])  #从第二个开始输出到第三个元素
print(createlist[-3:]) #从倒数第3个到倒数第一个元素  (特别值得关注输出从倒数第三个元素后的所有元素)
print(pjlist * 2)            # 输出两次列表
print(createlist + pjlist)   # 列表拼接

createlist[0] = 'This is a demo'  #与Python字符串不一样的是，列表中的元素是可以改变的
print(createlist[:]) #完整列表

letters = ['h','e','l','l','o']
print(letters[1:4:2])  #步长实验 1-e  3-l