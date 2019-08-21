#!/bin/bash
#Desc：Centos7安装后初始化脚本
echo -e "\n############################\n#网卡配置\n####################################\n"
sed -i 's/ONBOOT=no/ONBOOT=yes/g' /etc/sysconfig/network-scripts/ifcfg-ens192
sed -i 's/BOOTPROTO=dhcp/BOOTPROTO=static/g' /etc/sysconfig/network-scripts/ifcfg-ens192
cat >> /etc/sysconfig/network-scripts/ifcfg-ens192 <<EOF
IPADDR=10.10.107.239
NETMASK=255.255.255.0
GATEWAY=10.10.107.1
EOF
service network restart
echo nameserver 114.114.114.114 >> /etc/resolv.conf
echo "--[网卡配置结束]--"

echo -e "\n############################\n#SSH服务配置\n####################################\n"
sed -i 's/#PermitRootLogin/PermitRootLogin/g' /etc/ssh/sshd_config
systemctl restart sshd
echo "--[SSH服务配置结束]--"

echo -e "\n############################\n#采用阿里YUM源调换系统YUM源\n####################################\n"
curl -o /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
curl -o /etc/yum.repos.d/CentOS-epel.repo http://mirrors.aliyun.com/repo/epel-7.repo
yum clean all
yum makecache
yum update -y && yum upgrade -y &&  yum -y install epel*
echo "--[YUM替换更新应用软件完成]--"

echo -e "\n############################\n#安装常用的运维软件\n####################################\n"
yum install -y nano vim net-tools tree wget dos2unix unzip gcc gcc-c++ openssl-devel bzip2-devel
echo "--[安装安装完成]--"

echo -e "\n############################\n#安装COBBLER及其依赖\n####################################\n"
yum -y install xinetd syslinux dhcp tftp-server httpd rsync
install -y python-pip && pip install -U pip 
yum -y install cobbler cobbler-web pykickstart 
wget https://weiyigeek-1251733653.cos.ap-chengdu.myqcloud.com/file/2019/Cobbler_init.sh -O /tmp/
chmod +x /tmp/Cobbler_init.sh && /tmp/Cobbler_init.sh
echo "--[安装完毕]--"
