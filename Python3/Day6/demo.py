#!/usr/bin/python3
#案例：easygui模块的使用

import easygui as g

# nickname = input('请输入您的网名：')
# love = input("请输入您的爱好：")
# age = g.enterbox('请输入您的年龄：','信息输入')
# res = g.msgbox('您的输入的个人信息是：'+nickname+', 爱好：'+love+', 年龄：'+age,'个人信息','确认无误')
# print("msgbox返回值：",res)  #返回ok_button值  msgbox返回值： 确认无误
# sex = g.buttonbox('选择您的性别：','信息录入',('男','女','none'),default_choice='none')
# city = g.multchoicebox('城市选择','信息录入',['北京','上海','广州','深圳','重庆'])

# #选择建立文件的目录
# savedir = g.diropenbox(msg=None, title='', default=None)  
# test = g.fileopenbox(msg=None, title=None, default='*', filetypes=None, multiple=False)
# savefile = g.filesavebox(msg=None, title='保存文件的目录', default='', filetypes=None) 
# # C:\Users\Administrator\Documents 
# # C:\Users\Administrator\Desktop\Study-Promgram\README.md 
# # C:\Users\Administrator\Desktop\Study-Promgram\test.txt

# with open(savefile,'w+',encoding='utf-8') as f:
#     f.write(nickname+'\n'+love+'\n'+age+'\n'+res+'\n'+sex+'\n')
#     for x in city:
#         f.write(x+'\n')

g.textbox('测试','效率','value')
print("模块测试完成！")