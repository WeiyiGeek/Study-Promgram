#!/usr/bin/python3
# 功能：登陆login/register

user_data = {}
'提示'
def tip():
    print("###### 新建用户：N/n ######")
    print("###### 登陆用户：E/e ######")
    print("###### 登陆用户：Q/q ######")

'注册模块'
def reg():
    name = input("请输入注册名用户名")
    while True:
        if name in user_data:
            name = input("用户名已被占用,请重新输入：")
        else:
            break

    password = input("请输入密码：")
    user_data.setdefault(name, password)
    print("Ok.注册成功")

'登陆模块'
def login():
    name = input("请输入登陆的账户：")
    while True:
        if name not in user_data:
            name = input("输入的用户名不存在,请重新输入用户名：")
        else:
            break

    password = input("请输入密码：")

    if user_data[name] == password:
        print("Ok.登陆成功")
    else:
        print("Error.密码错误")

'主模块'
def user():
    tip()
    while 1:
        temp = input("|---请输入指令代码：")

        if temp.lower() == 'n':
            reg()
        if temp.lower() == 'e':
            login()
        if temp.lower() == 'q':
            break

    print("退出成功,欢迎下次使用！")

user()  #调用主模块
