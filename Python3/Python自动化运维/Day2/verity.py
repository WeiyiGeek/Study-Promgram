#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : verity.py
# @CreateTime : 2019/7/26 14:23
# @Author : WeiyiGeek
# @Function : 同步校验源文件/目标文件
# @Software: PyCharm

import os,sys
import filecmp
import shutil

holderlist = []
destination = []


def compareme(src, dest):
    dircomp = filecmp.dircmp(src, dest);
    onlyfile = dircomp.left_only    #源文件新目录或者文件
    difffile = dircomp.diff_files   #源目录中发生变化的文件（不匹配的文件）
    dirpath = os.path.abspath(src)

    #将发生变量的文件路径写入到，采用lamba表达式
    [holderlist.append(os.path.abspath(os.path.join(src, x))) for x in onlyfile]  #将源文件中创建的文件绝对路径存入数组中
    [holderlist.append(os.path.abspath(os.path.join(src, x))) for x in difffile]  #将源文件中的发生改变的文件/目录绝对路径存入数组中

    #src / desc 两边都存在的文件(继续递归对比)
    if len(dircomp.common_dirs):
        for item in dircomp.common_dirs:
            compareme(os.path.abspath(os.path.join(src, item)), os.path.abspath(os.path.join(dest, item)))
    return holderlist


def main():
    global destination,\
        holderlist
    if len (sys.argv) > 2:
        src = sys.argv[1]
        dest = sys.argv[2]
    else:
        print("""
           Usage: verity.py srcDirectory destDirectory
        """)
        sys.exit(1)

    source_files = compareme(src, dest)  #比较源目录与备份

    dir1 = os.path.abspath(src)
    dir2 = os.path.abspath(dest)

    createdir = False

    #变量返回差异性文件 (替换路径后重新放入destination数组中为后面的zip做准备)
    for item in source_files:
        #获取源文件中的目录
        destination_dir = item.replace(dir1,dir2)
        destination.append(destination_dir)

        #创建目录(再目录不存在的情况下)
        if os.path.isdir(item):
            if not os.path.exists(destination_dir):
                os.makedirs(destination_dir)
                createdir = True

    #如果创建目录，重新遍历新创建的目录
    if createdir:
        destination = [] #防止重复
        srcfile = compareme(dir1,dir2)
        holderlist = srcfile
        for item in srcfile:
            destination.append(item.replace(dir1,dir2))

    [ print(x) for x in destination]

    print("update item")
    copy_pair = zip(source_files, destination) #源/备份目录文件清单拆分成元组
    for item in copy_pair:      #判断文件复制操作
        if os.path.isfile(item[0]):
            shutil.copyfile(item[0],item[1])
        print(item)
if __name__ == '__main__':
    main()
