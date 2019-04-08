#!/usr/bin/python3
#功能：代码行数统计
import os
count = 0 # 代码行数

def filecount(dirpath):
    global count
    os.chdir(dirpath)
    for each_file in os.listdir(os.curdir):
        if os.path.isfile(each_file):
            with open(each_file,'r',encoding='utf8') as f:
                for index,value in enumerate(f):
                    count += 1
        elif os.path.isdir(each_file):
            filecount(each_file)
            os.chdir(os.pardir)


filecount('C:\\Users\\Administrator\\Desktop\\JAVA-Study')
print("当前目录中一共写了%d 行代码" %count)