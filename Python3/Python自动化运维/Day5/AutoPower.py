#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : AutoPower.py
# @CreateTime : 2019/7/31 15:23
# @Author : WeiyiGeek
# @Function : 自动触发开机
# @Software: PyCharm

from flask import Flask,request
import socket
import binascii
import struct
import time

#默认Flask配置
app = Flask(__name__)
@app.route('/AutoPower.html')
def hello_world():
  ip = request.args.get('ipaddr')
  mac = request.args.get('macaddr')
  if ip == '' or  ip == None:
    return '<p style="color:red">IP输入错误或者请求参数有误</p>';
  if mac == '' or mac == None or len(mac) != 17:
    return '<p style="color:red">MAC输入错误或者请求参数有误</p>';
  result = ' 正在对 IP = ' + ip + ", MAC = " + mac + " 的机器发送开机指令";
  send_data = wake_up(mac)
  send_magic_packet(send_data)
  return result + send_data.__str__();

#构造魔法启动包
'''
格式化mac地址，生成魔法唤醒包，然后发送。
mac格式： mac = A1B2C3D4E5F6
唤醒包格式： send_data = binascii.unhexlify('FF'*6 + str(mac)*16)
'''
def wake_up(mac='00-00-00-00-00-00'):
  mac = mac.replace('-','')
  data = b'FF' * 6 + (mac * 16).encode()
  send_data = b''
  for i in range(0, len(data), 2):
    send_data = send_data + struct.pack(b'B', int(data[i: i + 2], 16))  # int(data[i: i+2], 16) 把16进制转换成整数
  return send_data


def send_magic_packet(send_data):
  BROADCAST = '10.20.172.255'
  #broadcast_address = '255.255.255.255'
  #BROADCAST = '255.255.255.255'
  port = 9
  # s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
  # s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
  # s.sendto(send_data, (broadcast_address, port))
  print("正在发送数据包")

   # 通过socket广播出去，为避免失败，间隔广播三次
  try:
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
    sock.sendto(send_data, (BROADCAST, port))
    time.sleep(1)
    sock.sendto(send_data, (BROADCAST, port))
    time.sleep(1)
    sock.sendto(send_data, (BROADCAST, port))
    print("Done")
  except Exception as e:
    print(e)

if __name__ == "__main__":
  #运行flask设置调试模式，绑定IP和端口;
  app.run(host='0.0.0.0', port=80, debug=True);

