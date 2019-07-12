#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : difflibfile.py
# @CreateTime : 2019/7/11 17:34
# @Author : WeiyiGeek
# @Function : 实现两个文本之间的字符串比较
# @Software: PyCharm

import difflib

t1 = """text1
this is a demo!
front not diff file 
add string
"""

t2 = """text2
this is a demo!
front diff file
del string
"""

def main():
   t1line = t1.splitlines()  #以行为分割
   t2line = t2.splitlines()

   #示例1.输出到shell中
   diff = difflib.Differ()  #创建Differ对象
   result = diff.compare(t1line,t2line)
   # print("\n".join(list(result)))  #同下
   for i in list(result):     #缓缓输出结果 输出到标准输入内
       print(i)

    ##输出结果##
    # - text1
    # ?     ^
    #
    # + text2
    # ?     ^
    #
    #   this is a demo!

    # - front not diff file
    # ?     ----           -
    #
    # + front diff file  #这里不存在增量差异
    # - add string
    # ? - ^
    #
    # + del string
    # ?  ^^


   #示例2.生产美观的对比HTML格式文档
   d = difflib.HtmlDiff()
   with open("diff.html",'w+') as f:
       f.writelines(d.make_file(t1line,t2line))

if __name__ == '__main__':
    main()

