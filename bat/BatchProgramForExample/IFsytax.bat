@echo off
::if������DEMO
echo ��ǰִ���ļ���%~fs0
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
