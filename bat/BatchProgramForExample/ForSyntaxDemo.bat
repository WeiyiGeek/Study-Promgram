@echo off
::For 语法进行便利bat和txt为扩展的文件，并打开
for %%c in (*.bat *.txt) do type %%c
::For 语句来删除遍历的文件
for %%a in (*.txt) do echo "正在删除%%a" & del /s %%a
