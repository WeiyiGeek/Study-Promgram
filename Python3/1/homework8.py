#!/usr/bin/python3
#进制转换
while 1:
    temp = input("请输入一个整数(输入Q退出程序)：")
    if temp == 'Q':
        break
    temp = int(temp)
    print("十进制 -> 十六进制 ： %d -> 0x%x" %(temp,temp))
    print("十进制 -> 八进制 ： %d -> 0o%o" %(temp,temp))
    print("十进制 -> 二进制 ： %d ->" %temp, bin(temp))
