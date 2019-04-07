#!/usr/bin/python3
#密码验证：强度检查
# 密码安全性检查代码
#
# 低级密码要求：
#   1. 密码由单纯的数字或字母组成
#   2. 密码长度小于等于8位
#
# 中级密码要求：
#   1. 密码必须由数字、字母或特殊字符（仅限：~!@#$%^&*()_=-/,.?<>;:[]{}|\）任意两种组合
#   2. 密码长度不能低于8位
#
# 高级密码要求：
#   1. 密码必须由数字、字母及特殊字符（仅限：~!@#$%^&*()_=-/,.?<>;:[]{}|\）三种组合
#   2. 密码只能由字母开头
#   3. 密码长度不能低于16位

symbols = r'''`!@#$%^&*()_+-=/*{}[]\|'";:/?,.<>'''
chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'
nums = '0123456789'

password = input("输入检查的密码:")
length = len(password)

while (password.isspace() or length == 0):
    password = input("您输入的密码为空（或空格），请重新输入：")
    length = len(length)

#判断字符串长度
if length <= 8:
    flag_len = 1
elif length <16:
    flag_len = 2
else:
    flag_len = 3

flag_con = 0
#判断是否包含特殊字符
for each in password:
    if each in symbols:
        flag_con += 1
        break;

#判断是否包含字母
for each in password:
    if each in chars:
        flag_con += 1
        break;

#判断是否包含数字
for each in password:
    if each in nums:
        flag_con += 1
        break;

#结果打印
while 1:
    print("您的密码评级：",end="")
    if flag_len == 1 or flag_con == 1: 
        print("低")
    elif flag_len == 3 and flag_con == 3 and password[0].isalpha():
        print("高")
        break   #这里的break用得精辟
    else:
        print("中")

    print("请按以下方式提升您的密码安全级别：\n\
    \t1. 密码必须由数字、字母及特殊字符三种组合\n\
    \t2. 密码只能由字母开头\n\
    \t3. 密码长度不能低于16位")
    break