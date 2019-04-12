#!/usr/bin/python
#功能：urllib模块的使用

import urllib.request
req = urllib.request.Request("http://weiyigeek.club")
res = urllib.request.urlopen(req)
print("请求URL:\n",res.geturl())
print("状态码：",res.getcode())
print("返回消息头：\n",res.info())
print("请求头信息：",req.headers)
