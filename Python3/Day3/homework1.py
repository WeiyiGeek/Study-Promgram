#!/usr/bin/python3
#OS模块的使用

import os

all_files = os.listdir(os.curdir) # 使用os.curdir表示当前目录更标准 | 显示当前目录与文件
type_dict = dict() #类型
file_dict = dict() #文件及大小

for each_file in all_files:
    if os.path.isdir(each_file):
        type_dict.setdefault('文件夹', 0)
        type_dict['文件夹'] += 1
    else:
        #扩展名文件统计
        ext = os.path.splitext(each_file)[1]
        type_dict.setdefault(ext, 0)   #注意 当字典里面不存在的时候才会建立赋值为0 , 否则不对字典里面key/VALUE值进行操作
        type_dict[ext] += 1           #直接进行字典value运算

        #文件大小统计
        file_dict.setdefault(each_file,os.path.getsize(each_file))

#统计文件类型格式
for each_type in type_dict.keys():
    print('该文件夹下共有类型为【%s】的文件 %d 个' % (each_type, type_dict[each_type]))

#显示文件及其大小
for each_size in file_dict.items():
    print("fileName：%s , Size: %dBytes" %(each_size[0],each_size[1]))

#用户输入文件名以及开始搜索的路径
def search_file(start_dir, target) :
    os.chdir(start_dir) #进入目录
   
    for each_file in os.listdir(os.curdir) :
        if each_file == target :
            print(os.getcwd() + os.sep + each_file) # 使用os.sep是程序更标准
            break
        if os.path.isdir(each_file) :
            search_file(each_file, target) # 递归调用
            os.chdir(os.pardir)            # 递归调用后切记返回上一层目录


print("搜寻到文件：")
search_file(os.curdir,'homework1.py')