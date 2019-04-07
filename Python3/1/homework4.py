#!/usr/bin/python3
#功能：有一道有趣的数学题：有一个长阶梯，若每步上2阶，最后剩1阶；若每步上3阶，最后剩2阶；若每步上5阶，最后剩4阶；若每步上6阶，最后剩5阶；只有每步上7阶，最后刚好一阶也不剩。
#题目：请编程求解该阶梯至少有多少阶？
jieti = 7
while 1:
    if ( jieti % 2 == 1) and ( jieti % 3 == 2) and ( jieti % 5 == 4) and ( jieti % 6 == 5):
        print("至少有 %d 阶梯" %jieti)  #至少有 119 阶梯
        break
    else:
        jieti = jieti + 7 # 根据题意，x一定是7的整数倍，所以每次+ 7

x = 7
i = 1
flag = 0
while i <= 100:
    if (x%2 == 1) and (x%3 == 2) and (x%5 == 4) and (x%6==5):
        flag = 1
    else:
        x = 7 * (i+1) # 根据题意，x一定是7的整数倍，所以每次乘以7
    i += 1

if flag == 1:
    print('阶梯数是：', x)
else:
    print('在程序限定的范围内找不到答案！')

year = input("请输入一个年份：")
while not year.isdigit():
    year = input("输入错误请重新输入年份：")
year = int(year)

if (year % 400 == 0):
    print(year," 年是闰年！")
else:
    if (year % 4 == 0) and (year % 100 != 0):
        print(year," 年是闰年！")
    else:
        print(year," 年是平年！")    