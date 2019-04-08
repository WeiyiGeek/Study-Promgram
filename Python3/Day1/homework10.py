#!/usr/bin/python
#辗转相除法（欧几里德算法|计算大数效率高）

# def gcd(x,y):
#     while 1:
#         temp = x % y
#         if temp == 0:
#             return y
#         x, y = y, temp


# temp = input("输入除数与被除数利用,分割如( 319,377 ):")
# temp = temp.split(',')
# x = int(temp[0])
# y = int(temp[1])
# print("%d 与 %d 的最大公约数：" %(x,y),gcd(x,y))


def mFun(*param, base=3):
    result = 0
    for each in param:
        result += each

    result *= base
    
    print('结果是：', result)

mFun(1, 2, 3, 4, 5, base=5)
