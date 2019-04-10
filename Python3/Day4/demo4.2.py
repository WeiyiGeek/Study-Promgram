#!/usr/bin/python3
#模块：案例包导入模块主程序

## 项目结构
# │ demo4.2.py
# ├─Demo
# │  │  Module.py
# │  │  __init__.py

from Demo.Module import success  #在指定的Demo包下面找到模块并导入模块里面的函数(可直接调用)
success()  #直接调用

########## 执行结果 ##############
# 亲,您成功从包里导入模块中的函数到主程序里面,Yes!


