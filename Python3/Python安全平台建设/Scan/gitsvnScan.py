#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : gitsvnScan.py
# @CreateTime : 2019/7/17 9:40
# @Author : WeiyiGeek
# @Function : git与svn信息泄露扫描
# @Software: PyCharm
import sys
import requests

def git(url):
    try:
        g = requests.get(url+'config', timeout=5)
    except Exception as e:
        print("[*] 请求失败"+str(e))
    with open('gitconfig.txt','w') as config:
        config.writelines(g.text)
        print("[!] .git/config写入成功")


def svn(url):
    try:
        s = requests.get(url+'entries', timeout=5)
    except Exception as e:
        print("[*] 请求失败"+str(e))

    if (s.status_code == 200):
        with open('svnentries.txt','w') as config:
            config.writelines(s.text)
            print("[!] .svn/entries写入成功")

    try:
        s = requests.get(url + 'wc.db', timeout=5)
    except Exception as e:
        print("[*] 请求失败" + str(e))

    if (s.status_code == 200):
        with open('wc.db', 'wb') as config:
            config.write(s.content)
            print("[!] .svn/wc.db 写入成功")


def main(url):
    gitPath = url+'/.git/'
    svnPath = url+'/.svn/'
    try:
        g = requests.get(gitPath, timeout=5)
    except Exception as e:
        print("[*] 请求失败"+str(e))
    if (g.status_code == 200):
        git(gitPath)

    try:
        s = requests.get(svnPath, timeout=5)
    except Exception as e:
        print("[*] 请求失败" + str(e))
    if (s.status_code == 200):
        svn(svnPath)
    else:
        print("URL:", g.url, " status_code:", g.status_code)
        print("URL:", s.url, " status_code:", s.status_code)
        print("[*] 该站点不存在/.git或者/.svn信息泄露")


if __name__ == '__main__':
    if len(sys.argv) <= 1:
        print("usage: gitsvnScan.py http://url.com")
        sys.exit(1)

    main(str(sys.argv[1]))
