#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : webscreenshot.py
# @CreateTime : 2019/7/31 17:34
# @Author : WeiyiGeek
# @Function : 实现web页面爬取与页面图片
# @Software: PyCharm

import requests
from IPy import IP


def url(item):
    flag = 1

    weburl = "http://"+str(item)
    try:
      w = requests.get(weburl,allow_redirects=True, timeout=1, headers={'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0'})
    except Exception as err:
        print("[+]连接失败:"+weburl)
        flag = 0

    if flag == 1:
        print(w.headers)


def main():
    ip = IP('10.10.107.0/24')
    for item in ip:
        url(item)

if __name__ == '__main__':
     main()