@echo off
::��Ҫ�����Win7��Windows2008
color 0a
echo.
echo "�ر����ܿ�����,�����ý�ֹ����"
net stop SCardSvr
net stop SCPolicySvc

sc config SCardSvr start= disabled
sc config SCPolicySvc start= disabled
echo.
echo "Successful������"

rem ��������
net start MpsSvc
rem ��������
sc config MpsSvc start= auto

echo "���÷���ǽ"
netsh advfirewall set allprofiles state on

echo "���ζ˿�"

netsh advfirewall firewall add rule name="deny udp 137 " dir=in protocol=udp localport=137 action=block

netsh advfirewall firewall add rule name="deny tcp 137" dir=in protocol=tcp localport=137 action=block

netsh advfirewall firewall add rule name="deny udp 138" dir=in protocol=udp localport=138 action=block

netsh advfirewall firewall add rule name="deny tcp 138" dir=in protocol=tcp localport=138 action=block

netsh advfirewall firewall add rule name="deny udp 139" dir=in protocol=udp localport=139 action=block

netsh advfirewall firewall add rule name="deny tcp 139" dir=in protocol=tcp localport=139 action=block

netsh advfirewall firewall add rule name="deny udp 445" dir=in protocol=udp localport=445 action=block

netsh advfirewall firewall add rule name="deny tcp 445" dir=in protocol=tcp localport=445 action=block
echo.
echo ��ӷ���ǽ�ɹ�,���Զ�����,ȡ������cmd������shutdown -a
echo.
timeout /T 30
shutdown /r /t 30
pause
