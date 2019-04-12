#!/usr/bin/python3
#爬虫第三课：代理 一般urllib使用代理ip的步骤如下
#     设置代理地址
#         创建Proxyhandler
#         创建Opener
#         安装Opener


import urllib.request
import random

url1 = 'http://myip.kkcha.com/'
url2 = 'http://freeapi.ipip.net/'

proxylist = ['116.209.52.49:9999','218.60.8.83:3129']

ualist = ['Mozilla/5.0 (compatible; MSIE 12.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; QQBrowser/7.0.3698.400)',\
        'Mozilla/5.0 (Windows NT 6.7; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36',\
        'Mozilla/5.0 (Windows NT 6.7; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0'\
    ]

proxyip = random.choice(proxylist)

# 代理设置 参数是一个字典 {'类型':'代理IP:端口'}
proxy = urllib.request.ProxyHandler({'http':proxyip})
#创建一个定制一个opener
pro_opener = urllib.request.build_opener(proxy)
pro_opener.addheaders = [('User-Agent',random.choice(ualist))] #随机请求头

#安装opener
urllib.request.install_opener(pro_opener) 
##调用opener.open(url)

##利用代理进行请求
url2 = url2+proxyip.split(":")[0]
with urllib.request.urlopen(url1) as u:
    print(u.headers)
    res = u.read().decode('utf-8')
    print(res)

with urllib.request.urlopen(url2) as u:
    res = u.read().decode('utf-8')
    print(res)



################ 执行效果 ################
#X-Powered-By: PHP/5.6.40
# Content-Type: text/html; charset=UTF-8
# Content-Length: 2685
# Date: Fri, 12 Apr 2019 05:39:55 GMT
# Server: LiteSpeed
# X-Cache: MISS from li-ProLiant-DL360-Gen9
# X-Cache-Lookup: MISS from li-ProLiant-DL360-Gen9:3129
# Via: 1.1 li-ProLiant-DL360-Gen9 (squid/3.3.8)
# Connection: close

# <script type="text/javascript">
#                 var sRemoteAddr = '218.60.8.99';
# </script>
# </div>
#     您当前使用的浏览器：Mozilla/5.0 (compatible; MSIE 12.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; QQBrowser/7.0.3698.400)                  上述地址是您的访问互联网的最终IP地址，该地址只有通过访问互联网上的某个网站才能被确认。
# </div>

#["中国","辽宁","沈阳","","联通"]