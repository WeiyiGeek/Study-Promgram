#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @File : os.popen.py
# @CreateTime : 2019/8/9 15:18
# @Author : WeiyiGeek
# @Function : 
# @Software: PyCharm

import os
command = "netstat -an|findstr TCP"
lines = os.popen(command).readlines()
for line in lines:
    port=line.split()
    port=port[1].split(':')
    print(port[1])