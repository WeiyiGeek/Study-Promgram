@echo off
mode con: cols=85 lines=30
:TOPSEC
title  WannaCry���������ӹ̹���
color 0A
cls
echo.
echo -----------------  WannaCry���������ӹ̹���  ------------------
echo.
echo    * �������ӷ���ǽ���ԣ��������˷���ǽ���ᵼ��û�м������ǽ����Ķ˿��޷�����,���ֹ�����Ҫ���ŵĶ˿ڼ��뵽�����С�
echo.
echo    * ���������ڴ�ӡ���������ʹ��445�˿ڣ��ӹ̺���ܻ���ִ�ӡ�������쳣,���������Ҫ����ʹ��445�˿ڣ����ڰ�ȫ����ʦָ���¼ӹ̡�
echo.
echo    * ����: �߽����ǽ���445�˿ڵķ��ʣ���ͨ��IPS������ǽ��ذ�ȫ�豸���������ϲ��ԡ�
echo.
echo    * ����: ��΢���������MS17-010����,ѡ���Ӧ�İ汾���в�����װ����������
echo      ��ַ��https://technet.microsoft.com/zh-cn/library/security/MS17-010��
echo.
echo    * ������ϵͳ����Ա������У������ṩ�˹��������Ĳ����Ľ��ܣ�
echo.
echo       1��WIN7/XP�ӹ� 2��WIN10�ӹ� 3��WIN2003�ӹ� 4��WIN2008/2012�ӹ� 5.WIN2016�ӹ�
echo.
echo       6: �˳�
echo ----------------------------------------------------------------------------------
echo.
set start=
set /p start=����(1 2 3 4 5 6)�󰴻س���:
if "%start%"=="1" goto WIN7
if "%start%"=="2" goto WIN10
if "%start%"=="3" goto WIN2003
if "%start%"=="4" goto WIN2012
if "%start%"=="5" goto WIN2016
if "%start%"=="6" goto quit
goto TOPSEC

:WIN7
net stop server /Y > nul
netsh advfirewall set currentprofile state on > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationTCP" dir=in action=block localport=445 remoteip=any protocol=tcp > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationUDP" dir=in action=block localport=445 remoteip=any protocol=udp > nul
echo ---------------------------------------------------------------------------------
echo    *  Windows 7 OR XPϵͳ�Ѽӹ̳ɹ���
echo .
pause
goto TOPSEC

:WIN10
net stop server > nul
netsh firewall set opmode enable > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationTCP" dir=in action=block localport=445 remoteip=any protocol=tcp > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationUDP" dir=in action=block localport=445 remoteip=any protocol=udp > nul
echo ---------------------------------------------------------------------------------
echo    *  Windows 10ϵͳ�Ѽӹ̳ɹ���
echo .
pause
goto TOPSEC

:WIN2003
net stop server > nul
net start sharedaccess > nul
netsh firewall add portopening protocol = ALL port = 445 name = TOPSEC-DenyEquation mode = DISABLE scope = ALL profile = ALL > nul
echo ---------------------------------------------------------------------------------
echo    *  Windows Server 2003ϵͳ�Ѽӹ̳ɹ���
echo .
pause
goto TOPSEC

:WIN2012
net stop server > nul
net start MpsSvc > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationTCP" dir=in action=block localport=445 remoteip=any protocol=tcp > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationUDP" dir=in action=block localport=445 remoteip=any protocol=udp > nul
echo ---------------------------------------------------------------------------------
echo    *  Windows Server 2012 OR 2008ϵͳ�Ѽӹ̳ɹ���
echo .
pause
goto TOPSEC

:WIN2016
net stop server > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationTCP" dir=in action=block localport=445 remoteip=any protocol=tcp > nul
netsh advfirewall firewall add rule name="TOPSEC-DenyEquationUDP" dir=in action=block localport=445 remoteip=any protocol=udp > nul
echo ---------------------------------------------------------------------------------
echo    *  Windows Server 2016ϵͳ�Ѽӹ̳ɹ���
echo .
pause
goto TOPSEC
