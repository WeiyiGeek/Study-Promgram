#!/usr/bin/python3
#功能：正则与爬虫
from urllib.request import Request,urlopen,urlretrieve
from urllib.error import HTTPError,URLError
import re
import os

def url_open(url):
    req = Request(url)
    req.add_header('User-Agent','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0')
    try:
        res = urlopen(req)
        html = res.read()
    except HTTPError as e:
        print("服务器请求错误：",e.code())
        return 0
    except URLError as e:
        print("链接服务器Fail:",e.reason())
        return 0
    else:
        return html


def save_img(url,dir):
    i = 0
    os.mkdir(dir)
    os.chdir(os.curdir+'/'+dir)
    for each in url:
       #以后将要废弃不建议使用但是真心方便
       urlretrieve(each,str(i)+'.jpg',None)
       i += 1
    else:
        print("下载完成！\a\a")


def get_img(url):
    res = url_open(url).decode('utf-8')
    if res == 0:
        exit("请求错误退出")
    p = r'<img src="([^"]+\.jpg)"'
    imglist= re.findall(p,res)
    save_img(imglist,'test')
    print(imglist)
    
if __name__ == '__main__':
    url = 'http://tieba.baidu.com/f?kw=%E9%87%8D%E5%BA%86%E7%AC%AC%E4%BA%8C%E5%B8%88%E8%8C%83%E5%AD%A6%E9%99%A2&ie=utf-8&tab=album'
    get_img(url)