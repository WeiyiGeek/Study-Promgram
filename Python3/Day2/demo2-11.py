#!/usr/bin/python3
#功能：OS模块的使用

import os
print("当前路径：",os.getcwd())
os.chdir('C:\\Users\\Administrator\\Desktop\\Python')  #修改路径
print("修改后的路径：",os.getcwd())
os.mkdir('.\\test')         #创建目录
os.makedirs('.\\web\\a\\b')  # 目录已存在时，无法创建该目录以及多级目录
#os.remove('.\\demo2-10.txt')    #删除文件
os.rmdir('.\\test')              #移除单个目录
os.removedirs('.\\web\\a\\b')    #移除多个目录
print(os.system('DATE /T'))      #执行成功返回0，否则为1
print(list(os.walk(os.curdir)))  #遍历当前目录  os.pardir()
print('指定分隔符：',os.sep)
print('当前平台的中止符号: %s' %os.linesep)  #\r\n
print('当前使用的操作吸引:',os.name)