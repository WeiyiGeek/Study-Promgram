@echo off 
color 0a
title windows系统垃圾清理
echo ★☆            Win清理系统垃圾文件            ★☆★
echo 正在清除系统垃圾文件，请稍后

::Win7下面::是不支持得
::rmdir %windir%\$hf_mig$ /Q /S 
::dir %windir%\NtUninstall* /a:d /b >%windir%\12345.txt 
::for /f %%i in (%windir%\12345.txt) do rd %windir%\%%i /s /q 
::del %windir%\12345.txt /f /q 

:: %systemdrive% 就是当前的磁盘的跟目录
del /f /s /q %systemdrive%\*.tmp 
del /f /s /q %systemdrive%\*._mp 
del /f /s /q %systemdrive%\*.log 
del /f /s /q %systemdrive%\*.gid 
del /f /s /q %systemdrive%\*.chk 
del /f /s /q %systemdrive%\*.old 
del /f /s /q %systemdrive%\recycled\*.* 

::删除C:\Windows\temp中的所有文件及文件夹，和建立temp文件夹
rmdir /s /q %windir%\temp & md %windir%\temp
del /f /s /q %windir%\*.bak 
del /f /s /q %windir%\prefetch\*.* 

del /f /q %userprofile%\cookies\*.* 
del /f /s /q "%userprofile%\recent\*.*"
del /f /s /q "%userprofile%\local settings\temporary internet files\*.*"
del /f /s /q "%userprofile%\local settings\temp\*.*"
::上面的等同于del /f /s /q "%temp%\*.*"
echo 
echo ★☆                恭喜您！清理全部完成！                    ☆★
echo