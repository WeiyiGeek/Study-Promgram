@echo off
::数据库文件存在
if not exist c:\sqldump1.sql echo sqldump.sql no exist
if exist c:\sqldump.sql del sqldump.sql
cmd.exe
