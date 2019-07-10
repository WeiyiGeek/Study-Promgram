#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : dnsmonitorweb.py.py
# @CreateTime : 2019/7/10 16:58
# @Author : WeiyiGeek
# @Function : 实现DNS域名轮询业务监控
# @Software: PyCharm

import dns.resolver
import os
import urllib.request
import ssl

iplist=[]
domain="qq.com"

def get_ip(domain=""):
    try:
        A = dns.resolver.query(domain,'A')
    except Exception as e:
        print("DNS resolver error : %s " % str(e))
        return False
    for i in A.response.answer:
        for j in i.items:
            if j.address not in iplist:
                iplist.append(j.address)
                print("DNS A 记录：%s" %j)
    return True


def checkweb(ipaddr):
    url = "http://"+ipaddr
    content =""
    try:
        response = urllib.request.urlopen(url,timeout=5,context=ssl._create_unverified_context())  #定义http链接超时时间15秒,支持https请求
    except Exception as e:
        print("[URL请求错误]: \n%s" % str(e))
    finally:
        print("请求URL：", response.geturl())
        print("状态码：", response.getcode())
        print("返回消息头：\n%s" %response.info())

        if int(response.getcode()) == 200:
            print(ipaddr + " [alive]")
        else:
            print(ipaddr + " [Error]")

if __name__ == '__main__':
    if get_ip(domain) and len(iplist) > 0:
        for ip in iplist:
            checkweb(ip)
        else:
            print("监测完成")
    else:
        print("DNS Resolver Error!")