#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : filedircmp.py
# @CreateTime : 2019/7/12 10:21
# @Author : WeiyiGeek
# @Function : 文件/目录之间的对比
# @Software: PyCharm

import filecmp
import pprint

file1 = "./diff.html"
file2 = "./difflibfile.py"
dir1 = "../"
dir2 = "../../"

def main():
	#示例1.文件对比不同
	print("文件是否相同：%s" % str(filecmp.cmp(file1,file2,False)))
	print("文件是否相同：%s" % str(filecmp.cmp(file1,file2,True)))

    #示例2.实现目录差异对比功能
    #比较当前指定目录中内容
	dirobj = filecmp.dircmp(dir1,dir2,['diff.html']) #目录比较，忽略test.py文件
	print("\n[*]  report ")
	dirobj.report()

	#较当前指定目录及第一级子目录中的内容
	print("\n[*]  report partial closure ")
	dirobj.report_partial_closure()

	#递归比较所有指定目录的内容
	print("\n[*]  report full closure ")
	dirobj.report_full_closure()

	#dircmp类的其他属性参考上方
	print("dircmp类的left_list属性："+str(dirobj.left_list))
	print("dircmp类的left_only属性：")
	pprint.pprint(dirobj.left_only)


if __name__ == '__main__':
	main()
