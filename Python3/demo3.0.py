#!/usr/bin/python3
#功能：easyGUI简单得功能（更多请看配置文件）
import easygui as g
import sys
import os

# g.msgbox("hello,world")
# g.msgbox("I love study Python")
# while 1:
#     msg = "谁是最好得编程语言？"
#     title = "语言选择"
#     choices = ['PHP','Python','Javascript','node.js']
#     choices = g.choicebox(msg,title,choices)  #都是字符串,选择Cancel函数返回NONE
#     g.msgbox("您选择得是"+str(choices)+"编程语言")

#     if g.ccbox("再次游戏好吗?","test",choices=('YES', 
# 'NO')):
#         pass   #contiue
#     else:
#         sys.exit(0)  #cancel

#/****按钮****/
# if g.ynbox('这个使用于ccbox差不多','验证ynbox功能'):
#     print("F1按下")
# else:
#     print("F2按下")
#     g.msgbox("F2按下","测试ynbox功能")
# print("选择上面按钮显示对应得值"+g.buttonbox("选择您喜欢得水果","水果",choices=('Apple','Balana','荔枝'),image="1111.png")) 
# print(g.boolbox('测试boolbox功能'))  #返回boolean


#**/选项选择/***#
# test = os.listdir()
# choice = g.choicebox("在"+os.getcwd()+"目录下得文件目录有","当前目录下得文件",test)
# print("您选择得目录或者是 " + choice )
# g.multchoicebox("多选选择框","测试multchoicebox",test)

#/****用户输入***/#
input1 = g.enterbox("请输入您心里得话?")
g.msgbox(input1)
g.integerbox("测试intergerbox","输入数值在0-99",default=17,lowerbound=0,upperbound=99)


#/*****/

