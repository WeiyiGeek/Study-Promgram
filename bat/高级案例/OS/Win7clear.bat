@echo off 
color 0a
title windowsϵͳ��������
echo ���            Win����ϵͳ�����ļ�            ����
echo �������ϵͳ�����ļ������Ժ�

::Win7����::�ǲ�֧�ֵ�
::rmdir %windir%\$hf_mig$ /Q /S 
::dir %windir%\NtUninstall* /a:d /b >%windir%\12345.txt 
::for /f %%i in (%windir%\12345.txt) do rd %windir%\%%i /s /q 
::del %windir%\12345.txt /f /q 

:: %systemdrive% ���ǵ�ǰ�Ĵ��̵ĸ�Ŀ¼
del /f /s /q %systemdrive%\*.tmp 
del /f /s /q %systemdrive%\*._mp 
del /f /s /q %systemdrive%\*.log 
del /f /s /q %systemdrive%\*.gid 
del /f /s /q %systemdrive%\*.chk 
del /f /s /q %systemdrive%\*.old 
del /f /s /q %systemdrive%\recycled\*.* 

::ɾ��C:\Windows\temp�е������ļ����ļ��У��ͽ���temp�ļ���
rmdir /s /q %windir%\temp & md %windir%\temp
del /f /s /q %windir%\*.bak 
del /f /s /q %windir%\prefetch\*.* 

del /f /q %userprofile%\cookies\*.* 
del /f /s /q "%userprofile%\recent\*.*"
del /f /s /q "%userprofile%\local settings\temporary internet files\*.*"
del /f /s /q "%userprofile%\local settings\temp\*.*"
::����ĵ�ͬ��del /f /s /q "%temp%\*.*"
echo 
echo ���                ��ϲ��������ȫ����ɣ�                    ���
echo