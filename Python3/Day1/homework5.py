#!/usr/bin/python3
#设计一个验证用户密码程序，用户只有三次机会输入错误，不过如果用户输入的内容中包含"*"则不计算在内。
count = 3
password = '123456'

while count:
    temp = input("请输入密码：")
    if '*' in temp:
        continue
    elif temp == password:
        print("输入的密码正确")
        break;
    else:
        count = count - 1
        print("密码输入错误,您还有 %d 次机会" %count)

print("Login Successful")
