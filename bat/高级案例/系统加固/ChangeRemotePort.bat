@echo off
::����Զ�̷���˿�
color 0A
ECHO ----------------------------------------------------------------------------
ECHO.
ECHO ����Զ�̷���˿�
ECHO.
ECHO ----------------------------------------------------------------------------
ECHO.
echo REGEDIT4 >c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Tenninal Server] >> c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Tenninal Server\WinStations] >> c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Tenninal Server\WinStations\RDP-Tcp] >> c:\windows\reg.reg

::00001a11 6637�˿�

echo "PortNumber"=dword:00001a11 >> c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Terminal Server\Wds\rdpwd\Tds\tcp] >> c:\windows\reg.reg
echo "PortNumber"=dword:00001a11 >> c:\windows\reg.reg

regedit /s c:\windows\reg.reg

@echo �޸ĳɹ�3389�˿ڳɹ�
netsh advfirewall firewall add rule name=6673 dir=in action=allow protocol=TCP localport=6673
@echo ��ӷ���ǽ�˿ڳɹ�
cmd.exe
