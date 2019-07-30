@echo off
::截取字符串Demo
cls
set ifo=0123456789-ABCDEFGHIJKLMNOPQRSTUVWXYZ-abcdefghijklmnopqrstuvwxyz
echo 字符串Demo:%ifo%
echo [Demo1]
echo 截取前10个字符：
echo %ifo:~0,10%
echo [Demo2]
echo 截取后26个字符：
echo %ifo:~-26%
echo [Demo3]
echo 截取从第10个字符开始(10+1)-向后截取27个字符：
echo %ifo:~10,27%
echo [Demo4]
echo 截取从第23个字符开始(13+1)截取到后13个字符：
echo %ifo:~23,-13%
echo [Demo5]
echo 截取从第23个字符开始(13+1)截取向右最的后字符：
echo %ifo:~23%
echo [Demo6]
echo 截取从后数第53个字符开始(53),然后从这截取到得部分向后截取26个字符：
echo %ifo:~-53,26%
pause
