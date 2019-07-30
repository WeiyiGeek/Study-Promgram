@echo off
::参数的传递演示
::set a=%0
::echo 执行文件:%a%
::set a=%1
::echo Argumnent1:%a%
::echo ""

::采用Shift的方式
::这个Shift从第九个参数-1,从而$10 -> $9,不影响前的0-8的参数
::shift /8
::echo "第10个参数为"=%9

::采用循环的方式输出全部参数
 for %a in %* do echo %a

::这个Shift从上面得第3个参数-1，变成了%3->%2
shift /2
echo "第12个参数为"=%2
