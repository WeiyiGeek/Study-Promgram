#�����ļ�
open 192.168.1.166
ftp-user
passwd
prompt off
lcd D:\ftp
cd /home/myftp
mget *
close

#�ϴ�
open 10.10.12.12
ftp-user
passwd
lcd D:\ftp
cd /home/myftp
mput *
prompt on
bye
quit