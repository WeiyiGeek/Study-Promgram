@echo off
::利用Choice来IF判断选择第几个选项,Errorlevel会依次增加
choice /C dme /M "defrag,mem,end"
if errorlevel 3 goto end
if errorlevel 2 goto mem
if errotlevel 1 goto defrag

:defrag
c:\dos\defrag
goto end

:mem
mem
goto end

:end
echo good bye
