@echo off
set aa=C:\Windows\PPP\a.btx
::call ���Դ��ݲ���
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
::ת��ģʽ�ʹ������ʾ
::echo ^%%2 = %2  :: True������%%1��ʽ��ͬ
::echo ^%2 = %2   ::Error
