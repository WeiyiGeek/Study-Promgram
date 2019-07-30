@echo off
::错误代码等级的利用演示
cls
whoamis
if %ERRORLEVEL%==0 (
echo Program had return code 0
) else (
echo Program had return code %ERRORLEVEL%,This Program Not True Execute!!
)
echo ""
whoami
if %ERRORLEVEL%==0 (echo Program had return code 0) else echo Program had return code %ERRORLEVEL%,This Program Not True Execute!!

::下面是有BUG得
goto answer%ERRORLEVEL%
:answer0
echo Program had return code 0
goto godown
:answer1
echo Program had return code 1

:godown
whoami
::解决BUG
IF %ERRORLEVEL% GTR 1 goto bn else goto an
:an
echo Program had return code 1
pause>nul
exit
:bn
echo Program had return code %ERRORLEVEL%
