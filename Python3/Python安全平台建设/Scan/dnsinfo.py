#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : dnsinfo.py
# @CreateTime : 2019/7/10 15:28
# @Author : WeiyiGeek
# @Function : 实现DNS记录请求处理查看
# @Software: PyCharm

import sys
import dns.resolver

rdtype=['A','AAAA','MX','CNAME','NS','PTR',"SOA"]

def main(argv,flag=True):
    if flag:
        domain = argv
        for x in rdtype:
            print("\n # %s 记录" %x)
            try:
                for i in dns.resolver.query(domain,x).response.answer:
                    for j in i.items:
                        print("%s 记录：%s" %(x,j))
            except:
                print("[ERROR] 获取 %s 记录失败" %x)
    else:
        dnstype = argv[0].upper()
        domain = argv[1]
        try:
            if (dnstype in rdtype):
                for i in dns.resolver.query(domain,dnstype).response.answer:
                    for j in i.items:
                        print("%s 记录：%s" % (dnstype, j))
        except:
            print("[ERROR] 获取 %s 记录失败" % dnstype)

if __name__ == '__main__':
    if len(sys.argv) <= 1:
        print("描述：实现域名的dns信息查询与解析地址查询 \n \
        Usage: dnsinfo.py [ -t | -a ] domain \n \
        -a : 所有的请求记录 \n \
        -t : 指定请求记录A/AAAA/MX/CNAME/NS/PTR/SOA等等")
    elif (sys.argv[1] == "-t"):
        main(sys.argv[2:],flag=False)
    elif (sys.argv[1] == "-a"):
        main(sys.argv[2],flag=True)
    else:
        print("输入有误请参考帮助！")

