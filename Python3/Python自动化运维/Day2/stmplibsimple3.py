#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : stmplibsimple3.py
# @CreateTime : 2019/7/30 16:07
# @Author : WeiyiGeek
# @Function : 截屏图片发送与附件格式邮件发信
# @Software: PyCharm

import smtplib,os
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.image import MIMEImage
from PIL import ImageGrab


SMTPHOST = "smtp.qq.com"
SMTPUSER = "291238737@qq.com"
SMTPPASS = "iocztfbbfqxnbhda"
SUBJECT = u"截屏图片发送与附件格式邮件发信测试"
FROM = SMTPUSER
TO = "1564362804@qq.com"


def captrue():
    img = ImageGrab.grab(bbox=(0, 0, 1141, 610))
    img.save('captrue.jpg','JPEG')
    os.system("ipconfig > ip.txt")

def addimg(src, imgid):
    """
    添加图片与iD到mimeiMAGE对象中
    :param src: 图片路径 
    :param imgid: 图片id
    :return: 回imgImage对象
    """
    with open(src, 'rb') as img:
        msgimage = MIMEImage(img.read())  #创建MIMEImage对象以读取图片内容作为参数
        msgimage.add_header('Content-ID', imgid) #指定图片文件的Content-ID,img标签中使用
        return msgimage  #返回MIMEImage对象


def addacc():
    #创建一个MIMEText对象附加文档到邮件之中
    attach = MIMEText(open('./ip.txt','r').read(),"plain","utf-8")
    attach["Context-type"] = "text/plain"  #指定文件类型
    attach["Content-Disposition"] = "attachment; filename='ip.txt'"  #设置下载对话框
    return attach


def sendmain(msg):
    try:
        server = smtplib.SMTP_SSL(SMTPHOST)
        server.login(SMTPUSER, SMTPPASS)
        server.sendmail(FROM, TO, msg.as_string())
        server.quit()
        print("邮件发送：成功")
    except Exception as err:
        print("发送失败：" + str(err))


def emailContent():
    message = MIMEMultipart('related')  #创建MIMEutilpart对象并且采用related定义内嵌资源的邮件体
    msgtext = MIMEText("""
        <font color=red> 官网业务附件 </font>
        <table border="0" cellspacing="0" cellpadding="2">
            <tr bgcolor="#CECFAD" height="20" style="front-size:14px">
                <td colspan="2"> 系统截屏图片邮件发送 </td>
            </tr>
            <tr>
                <td>
                    <a href="www.weiyigeek.club"><img src="cid:captrue" alt="Python屏幕截图"></a>
                </td>
            </tr>
        </table>
        
    """,'html','utf-8')  #img标签的图片是通过Content-ID来引用的
    message.attach(msgtext)
    message.attach(addimg("./captrue.jpg", "captrue"))
    message.attach(addacc())
    message['Subject'] = SUBJECT
    message['From'] = FROM
    message['To'] = TO

    sendmain(message)  #邮件发送


def main():
    captrue()  #截屏
    emailContent() #邮件构造


if __name__ == '__main__':
    main()
