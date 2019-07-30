@echo off
::监视HTTP连接数的批处理脚本
:count
::echo|set /p test="Num of HTTP Connections:  " & netstat -na | find /C ":80"  
::有BUG也可能输出的是8008下面改进
echo  | set /p test="Num of HTTP Connections:  " & netstat -na | findstr "\<80\>" | find  /C ":80"    
echo  | netstat -na | findstr "\<80\>" | find  /N ":80"
::延迟秒执行
timeout 3 > nul
GOTO count