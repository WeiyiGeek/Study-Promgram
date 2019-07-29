#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : jsonDemo.py
# @CreateTime : 2019/7/25 13:11
# @Author : WeiyiGeek
# @Function : 
# @Software: PyCharm

import json
import xlwt
import requests

domainInfo=[]
domainName=[]
linenum = 0

def getTitle(url):
    try:
        r = requests.get(url, headers={'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0'},timeout=2)
    except Exception as e:
        return url+","+"连接失败"

    return url + "," + str(r.status_code)

def main():
    global linenum
    workbook = xlwt.Workbook(encoding='utf-8')
    worksheet = workbook.add_sheet('cqzk.com.cn')
    with open("get.json", "r", encoding='utf-8') as domain:
        res = json.load(domain)
        domainname = res["result"]["domain"]["name"]
        info = res["result"]["domain"]
        records = res["result"]["records"]
        for item in info:
            if item == "id" or item == "name" or item == "owner" or item == "status":
                domainInfo.append(info[item])
            elif item == "dnspod_ns":
                for key in info[item]:
                    domainInfo.append(key)

        worksheet.write(linenum, 0, "ID")
        worksheet.write(linenum, 1, "根域名")
        worksheet.write(linenum, 2, "绑定邮箱")
        worksheet.write(linenum, 3, "DNS服务器1")
        worksheet.write(linenum, 4, "DNS服务器2")
        worksheet.write(linenum, 5, "状态")

        linenum += 1
        listnum = 0
        for item in domainInfo:
            worksheet.write(linenum,listnum,item)
            listnum+=1

        linenum += 2
        worksheet.write(linenum, 0, "域名")
        worksheet.write(linenum, 1, "解析类型")
        worksheet.write(linenum, 2, "绑定地址")
        worksheet.write(linenum, 3, "线路")
        worksheet.write(linenum, 4, "TTL")
        worksheet.write(linenum, 5, "域名状态")
        worksheet.write(linenum, 6, "建立时间")


        for item in records:
            linenum += 1
            for key in item:
                if key != "":
                    subdomain = item["name"] + "." + domainname
                    if subdomain not in domainName:
                        domainName.append(subdomain)
                    worksheet.write(linenum, 0, subdomain)
                    worksheet.write(linenum, 1, item["type"])
                    worksheet.write(linenum, 2, item["value"])
                    worksheet.write(linenum, 3, item["line"])
                    worksheet.write(linenum, 4, item["ttl"])
                    worksheet.write(linenum, 5, item["status"])
                    worksheet.write(linenum, 6, item["updated_on"])
                    break

        linenum += 1
        for url in domainName:
            if '@' in url:
                continue
            linenum += 1
            res = getTitle("http://"+url).split(',')
            worksheet.write(linenum, 0, res[0])
            worksheet.write(linenum, 1, res[1])

        workbook.save('Excel_Workbook.xls')

if __name__ == '__main__':
    main()