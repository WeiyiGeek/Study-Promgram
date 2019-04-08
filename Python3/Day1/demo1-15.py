#!/usr/bin/python3
#coding:utf-8
#字符串内置方法

string = "thisisdemo"
print(string.capitalize())    #首字母大写 Thisisdemo
print(string.center(30,'-'))  #将指定字符居中,将剩下的使用-填充 Thisisdemo
print(string.count('i'))      #字符在字符串出现的次数 2

str = "Python编程语言"
str_gbk = str.encode("GBK")
print(str)   #字符编码
print("UTF-8 编码：",str.encode("UTF-8"))  #UTF-8 编码： b'Python\xe7\xbc\x96\xe7\xa8\x8b\xe8\xaf\xad\xe8\xa8\x80'
print("GBK 编码：", str_gbk )  #GBK 编码： b'Python\xb1\xe0\xb3\xcc\xd3\xef\xd1\xd4'
print(str_gbk.decode('GBK','strict')) #字符解码

print(str.endswith('言'))  #判断是否以它结尾返回 True
print(str.find('thon'))  #检测 str 是否包含在字符串中如果包含返回开始的索引值 2
print(str.rfind('thon'))  #同上只不过是从右开始查找 2

print("1234578".isdigit()) #检测字符串是不是都是数字 true
print(string.islower())   #如果字符串中包含至少一个区分大小写的字符
str = "This is String Example...Wow!!!"
print (str.title())   #将字符串所有的单词拼写首字母为大写 This Is String Example...Wow!!!
print (str.istitle())  #所有的单词拼写首字母是否为大写

print("ABC".lower())  #将大写转换成小写  abc
print("abc".upper())  #将小写转换成大写  ABC

# 创建字符映射的转换表
intab = "aeiou"
outtab = "12345"
trantab = str.maketrans(intab,outtab)
str = "this is string example....wow!!!"
print(str.translate(trantab))  #将str字符串的存在的字符采用映射表来替代 比如 i -> 3

print(str.replace('this','demo'))  #字符串替换
print(" this is a string ".strip())  #清空两边的空格 还有lstrip() / rstrip()
print('-'.join("this"))  #将序列中的元素以指定的字符连接生成一个新的字符串 t-h-i-s
print(str.split(" ")) #字符分割返回列表 ['this', 'is', 'string', 'example....wow!!!']
print("this".zfill(10)) #原字符串右对齐，前面填充0  000000this
print("t \r his \n is \n".splitlines())  #按照 ('\r', '\r\n', \n') 进行分割字符串 返回列表 ['t ', ' his ', ' is ']