@echo off
set aa=C:\Windows\PPP\a.btx
::call 可以传递参数
call :deal aaa %aa% "c c" ddd eee
pause>nul
exit
:deal
echo %%0 = %0
echo %%1 = %1
echo %%2 = %2
echo %%3 = %3
echo %%4 = %4
echo %%5 = %5
::转义模式和错误的演示
::echo ^%%2 = %2  :: True与上面%%1形式相同
::echo ^%2 = %2   ::Error
