#!/usr/bin/python
#爬取网站

import urllib.request
from urllib.error import HTTPError,URLError
import os

#进行网站的请求
def url_open(url,ref = False):
    req = urllib.request.Request(url)
    req.add_header('User-Agent','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0')
    if ref:
        req.add_header('Referer',url)
    res = urllib.request.urlopen(req)
    res = res.read()
    return res 

#获取mm照片地址
def get_mm(url,pageid,count):
    imglist = []
    for i in range(count):
        pageid += i
        html = url_open(url+str(pageid)).decode('utf-8')
        
        #注意点(如何找寻关键字)
        a = html.find('img src=')
        while a != -1:
            b = html.find('.jpg',a,a+255) #查询以.jpg结尾的位置
            if b == -1:
                b = a + 9
            else: 
                imgsrc = html[a+9:b+4]
                if imgsrc.split('/')[-1] != 'logo.jpg':
                    imglist.append(imgsrc)
            a = html.find('img src=',b)

    return imglist


#保存MM到磁盘中
def save_mm(imglist):
    for i in range(len(imglist)):
        print(imglist[i])
        img = url_open(imglist[i],True)
        imgname = imglist[i].split('/')[-1]
        with open(imgname,'wb') as f:
            f.write(img)


# 函数名:mian() 主函数入口
# 参数：[dir 建立目录, mm图网址, 页面pageid, 页面数量]
def main(url, pageid, count,dir='mm'):
    if not os.path.exists(dir):
        os.mkdir(dir)
    os.chdir(os.curdir+'/'+dir)

    imglist = []
    imglist = get_mm(url,pageid,count)
    save_mm(imglist)

if __name__ == "__main__":
    url = 'https://m.mzitu.com/'
    main(url,173810,30)  #传入url 和 mmapge ,爬取的数量

