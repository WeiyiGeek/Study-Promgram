#!/usr/bin/python3
#功能：课后作业

# try:
#     for i in range(3):
#         for j in range(3):
#             if i == 2:
#                  raise KeyboardInterrupt('')
#             print(i,j)
# except KeyboardInterrupt:
#     print("异常中断结束")


try:
    f = open('My_File.txt') # 当前文件夹中并不存在"My_File.txt"这个文件T_T (而且是一个局部变量)
    print(f.read())
except OSError as reason:
    print('出错啦：' + str(reason))
finally:
    if 'f' in locals(): # 如果文件对象变量存在当前局部变量符号表的话，说明打开成功
        f.close()

import random

secret = random.randint(1,10)
print('------------------我爱鱼C工作室------------------')
temp = input("不妨猜一下小甲鱼现在心里想的是哪个数字：")
try:    
    guess = int(temp)
except ValueError:
    print('输入错误！')
    guess = secret
while guess != secret:
    temp = input("哎呀，猜错了，请重新输入吧：")
    guess = int(temp)
    if guess == secret:
        print("我草，你是小甲鱼心里的蛔虫吗？！")
        print("哼，猜中了也没有奖励！")
    else:
        if guess > secret:
            print("哥，大了大了~~~")
        else:
            print("嘿，小了，小了~~~")
print("游戏结束，不玩啦^_^")
