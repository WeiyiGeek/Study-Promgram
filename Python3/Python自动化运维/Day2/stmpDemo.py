#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : stmpDemo.py
# @CreateTime : 2019/7/26 16:17
# @Author : WeiyiGeek
# @Function : 实现邮件的发送
# @Software: PyCharm

import smtplib
import socket
from email.mime.text import MIMEText

SMTPHOST = "smtp.qq.com"
SMTPUSER = "291238737@qq.com"
SMTPPASS = "xgovvrdgoetbbgeg"
FROM = "291238737@qq.com"
TO = "1564362804@qq.com"
Subject = "测试smtplib发信模块"


def info():
    # 获取计算机名称
    hostname = socket.gethostname()
    # 获取本机IP
    ip = socket.gethostbyname(hostname)
    return hostname + ip


def sendmail(From,To,boby):
    try:
        # server = smtplib.SMTP() #创建一个SMTP对象
        # server = smtplib.connect(SMTPHOST,"25") #非SSL方式连接smtp主机
        server = smtplib.SMTP_SSL(SMTPHOST)     # 通过SSL方法连接smtp主机默认使用465端口
        # server.starttls()  #启用安全传输模式
        server.login(SMTPUSER, SMTPPASS)  # 账号邮箱认证
        server.sendmail(From, To, boby)
        server.quit()
        print("发信成功! dindong")
    except Exception as e:
        print("[发信失败]!:" + str(e))


def main():
    Content = info()+"\r\n 我是一名电脑技术爱好者，我正在学习Python运维 "
    msg = MIMEText("""
    #创建一个MIMEtext对象，分别插入HTML内容/类型/文本/字符编码，
    <table width="400" border="1px solid red">
    <th>序号1</th><th>序号2</th>
    <tr>
        <td>主机名称</td><td>IP地址</td>
    <tr>
    </table>
    """+Content, "HTML" ,"UTF-8") #组装sendmail主体内容

    msg['Subject'] = Subject  #必须放在MIMEText后
    msg['From'] = FROM
    msg['To'] = TO
    sendmail(FROM, TO, msg.as_string())


if __name__ == '__main__':
    main()
