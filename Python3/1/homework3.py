#!/usr/bin/python3
#功能：课后作业05
import random
jihui = 3
secret = random.randint(1,10)
print('##############简单的数字游戏###############')
guess  = 0
print("请输入0~10之间的数字：",end='')

while (guess != secret) and (jihui > 0):
    temp = input()
    if temp.isdigit():
        guess = int(temp) 
        if (guess == secret):
            print("您刚好猜中数字：",secret) #猜中则会结束循环
        else:
            if (guess > secret):
                print("MAX  值大了，亲")
            else:
                print("Min 值小了，亲")
            if jihui > 1:
               print("请再尝试一次：",end='')
            else:
                print("请机会用光了")
    else:
        print("对不起,输入有误,需要重新输入。")
    jihui = jihui - 1  # 用户每输入一次，可用机会就-1
else:
    print("游戏结束！")
