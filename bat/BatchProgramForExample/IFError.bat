@ECHO OFF
::�������Ӵ�С(1  -  0)
XCOPY C:\Test.html D:\
echo %ERRORLEVEL%
IF ERRORLEVEL 1 ECHO �ļ�����ʧ��
goto end:
IF ERRORLEVEL 0 ECHO �ɹ������ļ�

::����Xcopy����ʾErrorLevel����
XCOPY C:\AUTOEXECa.BAT D:\
echo %ERRORLEVEL%
IF ERRORLEVEL 4 ECHO ����������д�̴���aa
goto end
IF ERRORLEVEL 3 ECHO Ԥ�ô�����ֹ�ļ���������
goto end
IF ERRORLEVEL 2 ECHO �û�ͨ��ctrl-c��ֹ��������
goto end
IF ERRORLEVEL 1 ECHO δ�ҵ������ļ�
goto end
IF ERRORLEVEL 0 ECHO �ɹ������ļ�
:end
pause