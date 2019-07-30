@echo off
title mysqldump
::数据库备份案例
color 8a
set user=%1
set pass=%2
set data=%3
if "%user%"=="" goto usage
if "%pass%"=="" goto usage
if "%date%"=="" goto usage
mysqldump.exe -u %1 -p%2 %3 > c:\sqldump.sql
echo Export Successful！！
goto end
:usage
echo Usage:%0 -u User -pPass DatabaseName
:end
pause
