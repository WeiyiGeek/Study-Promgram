@echo off
mode con:cols=85 lines=30
title oralce或者mysql服务启动与关闭
color 0a
::进行选择
choice /C O,y,M,n,q /M "startOrace,stopOracle,startMysql,stopMysql,quit"  /T 60 /D q
if ERRORLEVEL 5 goto end
if ERRORLEVEL 4 goto stopMysql
if ERRORLEVEL 3 goto startMysql
if ERRORLEVEL 2 goto stopOracle
if ERRORLEVEL 1 goto startOracle

::oralce service start
:startOracle
net start OracleVssWriterORCL
net start OracleDBConsoleorcl
net start OracleOraDb10g_home1iSQL*Plus
net start OracleOraDb10g_home1TNSListener
net start OracleServiceORCL
goto end

::oralce stop service
:stopOracle
net stop OracleServiceORCL
net stop OracleOraDb10g_home1TNSListener
net stop OracleOraDb10g_home1iSQL*Plus
net stop OracleDBConsoleorcl
net stop OracleVssWriterORCL
goto end

::mysql start service
:startmMysql
net start MySQL
goto end

::mysql stop service
:stopMysql
net stop MySQL

:end
echo.
echo 命令执行成功
echo.
pause
