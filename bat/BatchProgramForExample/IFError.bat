@ECHO OFF
::错误代码从大到小(1  -  0)
XCOPY C:\Test.html D:\
echo %ERRORLEVEL%
IF ERRORLEVEL 1 ECHO 文件拷贝失败
goto end:
IF ERRORLEVEL 0 ECHO 成功拷贝文件

::利用Xcopy来演示ErrorLevel号码
XCOPY C:\AUTOEXECa.BAT D:\
echo %ERRORLEVEL%
IF ERRORLEVEL 4 ECHO 拷贝过程中写盘错误aa
goto end
IF ERRORLEVEL 3 ECHO 预置错误阻止文件拷贝操作
goto end
IF ERRORLEVEL 2 ECHO 用户通过ctrl-c中止拷贝操作
goto end
IF ERRORLEVEL 1 ECHO 未找到拷贝文件
goto end
IF ERRORLEVEL 0 ECHO 成功拷贝文件
:end
pause