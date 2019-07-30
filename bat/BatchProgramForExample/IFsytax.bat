@echo off
::if语句测试DEMO
echo 当前执行文件：%~fs0
IF EXIST test.js (
       echo delete filename
       echo y|del test.js
) ELSE (
       echo filename. missing.
)
IF EXIST *.html (
       echo delete *.html
       echo y|del *.html
) ELSE (
       echo filename. missing.
)
cls
IF EXIST filename. (del filename.) ELSE echo "filename. missing"
IF EXIST filename. (del filename.) ELSE echo "filename. missing"
pause
