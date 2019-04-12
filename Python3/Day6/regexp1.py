#!/usr/bin/python3
#功能：re 模块基础方法

import re

p = re.compile(r'[a-z]+')    #编译正则表达式 = r'[a-z]{0,}'
print(p,p.search('abcdefg'))   #返回匹配对象 <re.Match object; span=(0, 8), match='abcdefg'>
print(p.match(""))         #空字符串不能被匹配因此match() 返回 None

print(re.search(r'\d\d\d','123a456').group()) #返回匹配的字符串

count = re.match(r'\d{0,3}','123a456')
print("开始位置  ",count.start()) #返回匹配的开始位置  
print("结束位置  ",count.end()) #返回匹配的结束位置
print("匹配的范围  ",count.span()) #返回匹配的范围

p = re.compile(r'\d+')
print(p.findall('3只甲鱼，15条腿，多出的3条在哪里？')) #['3', '15', '3']

iterator = []
iterator = p.finditer('3只甲鱼，15条腿，多出的3条在哪里？')
print(iterator)   # <callable_iterator object at 0x00000250DC49DA20>
for each in iterator:
    print(each.group(),each.span())

######### 执行结果 ############
# 开始位置   0
# 结束位置   3
# 匹配的范围   (0, 3)
# 3 (0, 1)
# 15 (5, 7)
# 3 (13, 14)
