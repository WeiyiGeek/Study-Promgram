@echo off
::ErrorLevel����ֵ
reg add HKCU /v try /f>nul
reg delete HKCU /v try /f
if %errorlevel%==0 (echo ɾ���ɹ�) else (echo ɾ��ʧ��)
reg delete HKCU /v try /f
if %errorlevel%==0 (echo ɾ���ɹ�) else (echo ɾ��ʧ�ܣ�
pause>nul
