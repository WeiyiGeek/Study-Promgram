#!/usr/bin/python3
#功能：OS模块使用

import os
import time
print(os.path.basename('E:\\web\\conf\\test.php'))
print(os.path.dirname('E:\\web\\conf\\test.php'))
print(os.path.join('E:\\','test\\demo.php'))  #注意path1在绝对路径需要加入转义符号
print(os.path.split('E:\\web\\conf\\test.php'))
print(os.path.splitext('E:\\web\\conf\\test.php'))
print(os.path.getsize(os.curdir + '\\python.txt'),'Bytes')
print("建立时间：",os.path.getctime(os.curdir + '\\python.txt'),'ms')
print("修改时间：",os.path.getmtime(os.curdir + '\\python.txt'),'ms')
print("访问时间：",os.path.getatime(os.curdir + '\\python.txt'),'ms')

if os.path.exists('.\\python.txt'):
    print("目录或者文件存在")
else:
    print('目录或者文件不存在')

print("是否为绝对路径：",os.path.isabs('.\\python.txt'))
print("是否是文件:",os.path.isfile('.\\python.txt'),"是否是目录:",os.path.isdir(os.pardir+'\\python'))
print("判断是否是挂载点：",os.path.ismount('D:\\'))

print("格林：",time.gmtime(os.path.getctime(os.curdir + '\\python.txt')))
print("本地：",time.localtime(os.path.getctime(os.curdir + '\\python.txt')))