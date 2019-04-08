#!/usr/bin/python3
#功能：课后作业03
import random

name = input("请输入您的姓名：")
num = input('请输入一个1~100的数中:')
num = int(num)
if num > random.randint(0,100):
    print("恭喜您：" + name,"您输入的数字"+ num +"大于随机数")
else:
    print("不能恭喜您了",name)

#所见即所得
string = """
WeiyiGeek,
Python,
脚本语言.
"""
print(string)

#需要进行转义才行
string = (
"我爱鱼C，\n"
"正如我爱小甲鱼，\n"
"他那呱唧呱唧的声音，\n"
"总缠绕于我的脑海，\n"
"久久不肯散去……\n")
print(string)

