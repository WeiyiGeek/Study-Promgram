#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : pycurldemo.py
# @CreateTime : 2019/7/31 15:23
# @Author : WeiyiGeek
# @Function : 实现探测Web服务质量
# @Software: PyCharm


import sys
import pycurl
from selenium import webdriver

URL="http://weiyigeek.club"


def request():
    """
     构建请求
    :return:
    """
    pc = pycurl.Curl()  #构建一个Curl对象
    pc.setopt(pycurl.URL, URL) #定义请求的URL
    pc.setopt(pycurl.CONNECTTIMEOUT, 5) #连接等待时间，0为不等待
    pc.setopt(pycurl.TIMEOUT, 5)  #请求超时时间
    pc.setopt(pycurl.NOPROGRESS, 1)  #疲敝下载进度条 与 curl 相似
    pc.setopt(pycurl.FORBID_REUSE, 1) #完成交互后断开连接不重用
    pc.setopt(pycurl.MAXREDIRS, 1)   #指定HTTP重定向的最大数为1
    pc.setopt(pycurl.DNS_CACHE_TIMEOUT, 30)  #报错DNS信息为30s
    pc.setopt(pycurl.USERAGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0")

    #创建一个文件对象以'wb'方式打开，存储返回的http头部信息以及页面内容;
    with open('content.txt', 'wb') as index:
        pc.setopt(pycurl.WRITEHEADER, index)  #将返回HTTP HEADER定向到indexfile文件对象
        pc.setopt(pycurl.WRITEDATA, index)  #将返回的HTML内容定向到indexfile文件对象中
        try:
            pc.perform()  #提交请求
        except Exception as e:
            print("connect Error:" + str(e))
            sys.exit()

    return pc


def reponse(pc):
    """
    返回请求响应数据解析
    :param pc:
    :return:
    """
    print("HTTP状态码: %s" %(pc.getinfo(pc.HTTP_CODE)))
    print("DNS解析时间: %.2f ms" %(pc.getinfo(pc.NAMELOOKUP_TIME)*1000))
    print("建立连接时间: %.2f ms" %(pc.getinfo(pc.CONNECT_TIME)*1000))
    print("准备传输时间: %.2f ms" %(pc.getinfo(pc.PRETRANSFER_TIME)*1000))
    print("传输开始时间: %.2f ms" %(pc.getinfo(pc.STARTTRANSFER_TIME)*1000))
    print("传输结束总时间: %.2f ms" %(pc.getinfo(pc.TOTAL_TIME)*1000))
    print("下载数据包大小: %d bytes/s" %(pc.getinfo(pc.SIZE_DOWNLOAD)))
    print("HTTP头部大小: %d byte" %(pc.getinfo(pc.HEADER_SIZE)))
    print("平均下载速度: %d bytes/s" %(pc.getinfo(pc.SPEED_DOWNLOAD)))
    print("重定向消耗的时间: %.2f ms" % (pc.getinfo(pc.REDIRECT_TIME) * 1000))
    pc.close()


def main():
    """
    请求函数调用
    响应函数调用
    :return:
    """
    pcurl = request()
    reponse(pcurl)
    #网站截图生成
    driver = webdriver.Chrome(executable_path=r'D:\Googledriver\chromedriver.exe')
    driver.get(URL)
    driver.get_screenshot_as_file('./BreezePython.png') #    print(driver.get_screenshot_as_base64())

    driver.close()


if __name__ == '__main__':
    main()