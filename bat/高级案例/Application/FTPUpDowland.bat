#下载文件
open 192.168.1.166
ftp-user
passwd
prompt off
lcd D:\ftp
cd /home/myftp
mget *
close

#上传
open 10.10.12.12
ftp-user
passwd
lcd D:\ftp
cd /home/myftp
mput *
prompt on
bye
quit