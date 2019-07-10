#!/usr/bin/env python
#功能：更具输入的IP或网段返回网络,掩码/广播/反向解析信息，子网数以及IP类型的等等信息
#author：WeiyiGeek

from IPy import IP
import sys

def doc():
    print("Useage: > ipinfo.py -t/-m 192.168.1.1 \n" \
          "-t 指定IP类型地址进行相互转换二进制IP/整数IP/十六进制 \n" \
          "-m 指定IP类地址或者IP段查看信息 \n" \
          "IP格式1：192.168.1.1 \n" \
          "IP格式2：192.168.1.0/24 \n" \
          "IP格式3：192.168.1.1-192.168.1.254"
          )
def main(argv):
    if (argv == ""):
        doc()
        ipaddr = input('please input an IP or net-range : ')
    else:
        ip = IP(argv)
    #判断如果子网数量大于1则是网段，否则是但IP地址;
    print("地址类型: %s" %ip.iptype())
    if len(ip) > 1:
        print("net/netmask : ",ip.net(),"/",ip.netmask())  #网络地址和子网掩码地址
        print("broadcast : %s" % ip.broadcast())  #广播地址
        print("reverse address : %s" % ip.reverseNames()[0])  #解析地址返回一个列表
        print("subnet length : %s" % ip.len())  #网络子网数量
    else:
        print("reverse address : %s" % ip.reverseName())  #IP地址反向解析
    transformation(ip)

def transformation(argv):
    #IP段就是首IP地址的转换
    ip = argv
    print("IP : %s" % ip.net())
    print("hexadecimal : %s" % ip.strHex())
    print("binaray ip : %s" % ip.strBin())
    print("number ip :  %s" % ip.int())


if __name__ == '__main__':
    if(len(sys.argv) <= 1):
        doc()
    elif (sys.argv[1] == "-t"):
        transformation(IP(sys.argv[2]))
    elif (sys.argv[1] == "-m"):
        main(sys.argv[2])
