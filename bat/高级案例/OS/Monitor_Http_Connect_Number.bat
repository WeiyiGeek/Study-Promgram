@echo off
::����HTTP��������������ű�
:count
::echo|set /p test="Num of HTTP Connections:  " & netstat -na | find /C ":80"  
::��BUGҲ�����������8008����Ľ�
echo  | set /p test="Num of HTTP Connections:  " & netstat -na | findstr "\<80\>" | find  /C ":80"    
echo  | netstat -na | findstr "\<80\>" | find  /N ":80"
::�ӳ���ִ��
timeout 3 > nul
GOTO count