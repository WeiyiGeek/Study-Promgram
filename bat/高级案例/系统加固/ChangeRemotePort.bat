@echo off
::更改远程服务端口
color 0A
ECHO ----------------------------------------------------------------------------
ECHO.
ECHO 更改远程服务端口
ECHO.
ECHO ----------------------------------------------------------------------------
ECHO.
echo REGEDIT4 >c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Tenninal Server] >> c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Tenninal Server\WinStations] >> c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Tenninal Server\WinStations\RDP-Tcp] >> c:\windows\reg.reg

::00001a11 6637端口

echo "PortNumber"=dword:00001a11 >> c:\windows\reg.reg
echo [HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Terminal Server\Wds\rdpwd\Tds\tcp] >> c:\windows\reg.reg
echo "PortNumber"=dword:00001a11 >> c:\windows\reg.reg

regedit /s c:\windows\reg.reg

@echo 修改成功3389端口成功
netsh advfirewall firewall add rule name=6673 dir=in action=allow protocol=TCP localport=6673
@echo 添加防火墙端口成功
cmd.exe
