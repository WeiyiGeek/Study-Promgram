#!/usr/bin/python
#功能：爬虫的第一课

import urllib.request   #导入urllib包里面的指定模块

#案例1：
response = urllib.request.urlopen("http://www.weiyigeek.club")
html = response.read()   #进行返回一个二进制取字符串 
html = html.decode('utf-8')  #解码操作
print("正在写入文件之中.....")
f = open('weiyigeek.txt','w+',encoding='utf-8')  #打开
f.writelines(html)
f.close()  #关闭
print("网站请求的结果：\n",html)

#案例2：
url = "http://placekitten.com/g/600/600"
response = urllib.request.urlopen(url)  #可以是url字符串或者文档,返回一个对象
img = response.read()
filename = url[-3:]+'.jpg'
with open(filename,'wb+') as f:   #注意这里存储二进制
    f.write(img)
