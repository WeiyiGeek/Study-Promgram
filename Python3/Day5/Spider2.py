#!/usr/bin/python
#功能：爬虫的第2课 JSON / 代理

import urllib.request
import urllib.parse
import json
import time

url = 'http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule'

while True:
    i = input("请输入翻译的英文(输入Q退出)：")
    if i == 'Q' or i == 'q':
        break
    
    data = {}
    data['i'] = i
    data['from'] = 'AUTO'
    data['to'] = 'AUTO'
    data['doctype'] = 'json'
    data['smartresult'] = 'dict'
    data['client'] = 'fanyideskweb'
    data['version'] = '2.1'
    data['keyfrom'] = 'fanyi.web'
    data['salt'] = '15550362545153'
    data['sign'] = 'a28b8eb61693e30842ebbb4e0b36d406'
    data['action'] = 'FY_BY_CLICKBUTTION'
    data['typoResult'] = 'false'
    data = urllib.parse.urlencode(data).encode('utf-8')

    #修改Header
    #url 对象 request 以及 添加 请求头信息
    req = urllib.request.Request(url, data)  #也能直接传入 header 对象字典
    req.add_header('User-Agent','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0')
    req.add_header('Cookie',' YOUDAO_MOBILE_ACCESS_TYPE=1; OUTFOX_SEARCH_USER_ID=597755369@10.169.0.84; OUTFOX_SEARCH_USER_ID_NCOO=1911553850.7151666; YOUDAO_FANYI_SELECTOR=ON; DICT_UGC=be3af0da19b5c5e6aa4e17bd8d90b28a|; JSESSIONID=abc8N5HySla85aD-6kpOw; ___rl__test__cookies=1555036254514; UM_distinctid=16a0f2c1b0b146-0612adf0fe3fd6-4c312c7c-1fa400-16a0f2c1b0c659; SESSION_FROM_COOKIE=fanyiweb')
    req.add_header('Referer','http://fanyi.youdao.com/')

    #url 请求返回的对象
    res = urllib.request.urlopen(req)
    html = res.read().decode('utf-8')

    jtarget = json.loads(html)   #json解析
    print("翻译后的结果 :",jtarget['translateResult'][0][0]['tgt'])
    time.sleep(1)  #延迟1s 防止请求频繁
    print("请求头信息：",req.headers)
    print("请求URL:",res.geturl())
    print("状态码：",res.getcode())
    print("返回头消息：\n",res.info())

# 请输入翻译的英文(输入Q退出)：whoami
# 翻译后的结果 : 显示本用户信息
# 请求头信息： {'User-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 'Cookie': ' YOUDAO_MOBILE_ACCESS_TYPE=1; OUTFOX_SEARCH_USER_ID=597755369@10.169.0.84; OUTFOX_SEARCH_USER_ID_NCOO=1911553850.7151666; YOUDAO_FANYI_SELECTOR=ON; DICT_UGC=be3af0da19b5c5e6aa4e17bd8d90b28a|; JSESSIONID=abc8N5HySla85aD-6kpOw; ___rl__test__cookies=1555036254514; UM_distinctid=16a0f2c1b0b146-0612adf0fe3fd6-4c312c7c-1fa400-16a0f2c1b0c659; SESSION_FROM_COOKIE=fanyiweb', 'Referer': 'http://fanyi.youdao.com/'}
# 请求URL: http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule
# 状态码： 200
# 返回头消息：
#  Server: Tengine
# Date: Fri, 12 Apr 2019 03:23:02 GMT
# Content-Type: application/json;charset=utf-8
# Transfer-Encoding: chunked
# Connection: close
# Vary: Accept-Encoding
# Vary: Accept-Encoding
# Content-Language: en-US