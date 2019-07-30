@echo off
color 0A
for %%i in (*) do echo %%i
::For 语法进行便利bat和txt为扩展的文件，并打开
For %%c in (*.bat *.txt) do type %%c

::For 语句来删除遍历的文件
::for %%a in (*.txt) do echo "正在删除%%a" & del /s %%a

::显示硬盘分区，IF与For的联合应用
set str=c d e f g h i j k l m n o p q r s t u v w x y z 
echo 当前硬盘的分区有： 
for %%i in (%str%) do if exist %%i: echo %%i: 

:
::For /d 显示当前目录下的目录
for /d %%i in (*) do @echo %%i  


::For /R 显示当前目录下的目录所有文件(Recurision会递归)
for /r f:\rep %%i in (*) do @echo %%i  
color 0B
for /r %%i in (*) do @echo %%i  


::for /l 数值增量递加
for /l %%i in (1,1,5) do echo %%i
for /l %%i in (1,1,3) do calc


::For /F 得行字符读取的特性
for /f %%i in (test.txt) do echo %%i


::For /F 的限定符参数，进行分节
for /f "delims=，" %%i in (test.txt) do echo %%i 


::For /F 的限定符参数与选择显示分节的内容
for /f "tokens=2 delims=.，" %%i in (test.txt) do echo %%i 
for /f "tokens=2,5  delims=，" %%i in (Test1.txt) do echo %%i %%j


::显示连续或者指定字节or之后的全部字节
for  /f  "delims=，  tokens=1,2,3,4,5"  %%i  in  (test1.txt)  do echo %%i %%j %%k %%l %%m 
::效果同上
for /f "delims=， tokens=1,*" %%i in (test1.txt) do echo %%i %%j
for /f "delims=，  tokens=1,2-4,*" %%i in (test1.txt) do echo %%i %%j %%k %%m


::For的高级利用可以分割ip地址与端口
for /f "delims=:" %%i in (ip.txt) do echo 获取到的IP地址是:%%i
for /f "delims=: tokens=2" %%i in (ip.txt) do echo 获取到的Port是:%%i


::跳跃指定的行数,N+1开始显示
for /f "skip=2" %%i in (test.txt) do echo %%i 


::忽略Ingore指定字符为开头的行
for /f "eol=论" %%i in (test.txt) do echo %%i 


::执行Command来保存到内存文件格式中,然后让for进行读取
for /f %%i in ('dir /a-d/b *.*') do echo %%i  

::改变字符串里面的分割符号
for /f "delims=. tokens=1-3" %%i in ("bbs.bathome.cn") do echo %%i-%%j-%%k 

::利用usebackq选择进行读取特殊文件名
for /f "usebackq" %%i in ("test 1.txt") do echo %%i 































































