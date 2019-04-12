#!/usr/bin/python3
#功能：urllib 异常处理

from urllib.request import Request,urlopen
from urllib.error import HTTPError,URLError

urlerror = 'http://www.weiyigeek.com'
urlcode = 'http://www.weiyigeek.club/demo.html'

def url_open(url):
    req = Request(url)
    req.add_header('APIKEY','This is a password!')
    try:
        res = urlopen(req)
    except (HTTPError,URLError) as e:
        if hasattr(e,'code'):  #需要放在reason属性前面
            print('HTTP请求错误代码：', e.code)
            print(e.read().decode('utf-8'))  #[注意]这里是e.read
        elif hasattr(e,'reason'):
            print('服务器链接失败',e.reason)
    else:
        print("Suceeccful！")

if __name__ == '__main__':
    url_open(urlerror)
    url_open(urlcode)

################## 执行结果 #####################
# 服务器链接失败 [Errno 11001] getaddrinfo failed
# HTTP请求错误代码： 404
# <html>
# <head><title>404 Not Found</title></head>
# <body>
# <center><h1>404 Not Found</h1></center>
# <hr><center>nginx/1.15.9</center>
# </body>
# </html>