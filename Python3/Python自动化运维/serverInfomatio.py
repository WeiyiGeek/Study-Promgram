#!/usr/bin/env python3
# -*- coding:utf-8 -*-
#功能：系统基础信息模块收集
import psutil
import datetime
from subprocess import PIPE

def Memory():
    mem = psutil.virtual_memory()
    swap = psutil.swap_memory()
    total = round(mem.total / pow(1024,3),2)
    free = round(mem.available / pow(1024,3),2)
    use = total - free
    print("系统内存信息：")
    print("\tTotal：{1:.2f} {0} \n\tUse：{2:.2f} {0} \n\tFree: {3:.2f} {0} \
         \n\t内存使用百分比：{4:.2f}% \n".format("GB",total,use,free,mem.percent))  # 格式化数据
    print("\tswapTotal：{1:.2f} {0} \n\tswapUse：{2:.2f} {0} \n\tswapFree: {3:.2f} {0} \
         \n\t交换分区使用百分比：{4:.2f}% \n".format("GB",swap.total / pow(1024,3)  ,swap.used / pow(1024,3) ,swap.free / pow(1024,3),swap.percent))  # 格式化数据

def Cpu():
    cpu = psutil.cpu_times()
    cpucount = psutil.cpu_count()
    print("系统处理器信息：")
    print("\tUser：{1:.2f} \n\
        Sysetm：{2:.2f} \n\
        idle: {3:.2f} \n\
        CPU逻辑个数：{4:d} \n\t".format("",cpu.user,cpu.system,cpu.idle,cpucount))  # 格式化数据

def Disk():
    disk = psutil.disk_partitions();
    diskio = psutil.disk_io_counters()
    print("系统磁盘信息：")
    for i in disk:
        print(i.device,i.fstype,i.opts,end="\n")
        diskname = psutil.disk_usage(i.device)
        diskvalue = []
        for j in diskname:
            diskvalue.append(j)
        print("Total: {1:.2f}{0} Used: {2:.2f}{0} Free: {3:.2f}{0} 磁盘使用百分百：{4:.2f}%\n".format("GB",diskvalue[0] / pow(1024,3),diskvalue[1] / pow(1024,3),diskvalue[2] / pow(1024,3),diskvalue[3]))
    print("磁盘IO信息：Read:",diskio.read_count," Read_time: ",diskio.read_time,"\tWrite:",diskio.write_count," Write_time: ",diskio.write_time,"\n")       

def Net():
    ip = psutil.net_if_addrs()
    netio = psutil.net_io_counters()
    print("系统网卡信息：")
    for i in ip:
        print("\t",i,end="\t")
        for x in ip[i]:
            print(x.address,end="  ")
        print("")
    print("\n\t Bytes_sent : {0:d}  Bytes_recv : {1:d} \n\t packets_sent(发送数据包) : {2:d}  packets_recv(接收数据包)：{3:d}\n".format(netio.bytes_sent,netio.bytes_recv,netio.packets_sent,netio.packets_recv))
    

def Info():
    users = psutil.users()
    print("系统用户信息:")
    for i in users:
        print("\t",i,end=" ")
    print("\t系统开启时间：",datetime.datetime.fromtimestamp(users[0].started).strftime("%Y-%m-%d %H:%M:%S"))
    print("\t开机时间：",datetime.datetime.fromtimestamp(psutil.boot_time()).strftime("%Y-%m-%d %H:%M:%S"),end="\n\n")


def Process():
    print("系统进程信息:")
    pid = psutil.pids();
    for pidnum in pid:
        print("\t",psutil.Process(pidnum).pid,":",psutil.Process(pidnum).name())


#系统性能信息：内存 / CPU / 磁盘 / 网络 / 杂类  
def systemPerformance():
   Cpu()
   Memory()
   Disk()
   Net()
   Info()
   Process()
   
   #通过psutil的Popen()方法启动应用程序,可以跟踪该程序运行的所有相关信息
   p = psutil.Popen(["python","-c","print('Hello World!')"],stdout=PIPE)
   print(p)
   print(p.username(),p.communicate())


if __name__ == "__main__":
    systemPerformance()
