#!/usr/bin/python3
#urllib爬虫最后一课

import urllib.request
from urllib.error import HTTPError,URLError
import re
import os

def url_open(url):
    req = urllib.request.Request(url)
    req.add_header('User-Agent','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0')
    try:
        res = urllib.request.urlopen(req)
    except (HTTPError,URLError) as e:
        print("出现错误:",e.code,'错误的网页:',e.read())
        return 0
    else:
        return res.read().decode('utf-8')

def main1(url,filename):    
    html = url_open(url)
    if html == 0:
        exit("请求错误,程序退出!")
    exp = r'<td>((?:(?:[01]{0,1}\d{0,1}\d|2[0-4]\d|25[0-5])\.){0,3}(?:[01]{0,1}\d{0,1}\d|2[0-4]\d|25[0-5]))</td>\n(?:\s*?)<td>(?P<port>\d{0,4})</td>'  #这里是坑呀
    regres = re.findall(exp,html,re.M)
    
    iplist = []
    for each in regres:
        ipport = each[0] + ':' + each[1]
        iplist.append(ipport)

    with open(filename,'w+',encoding='utf-8') as f:
        for i in range(len(iplist)):
            f.write(iplist[i]+'\n')

if __name__ == '__main__':
    url = 'https://www.xicidaili.com/nn/'
    main1(url,'proxyip.txt')

######### 抓取代理结果 ################
# 119.102.186.99:9999
# 111.177.175.234:9999
# 222.182.121.10:8118
# 110.52.235.219:9999
# 112.85.131.64:9999