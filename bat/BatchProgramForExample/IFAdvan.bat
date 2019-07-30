@ECHO OFF
::判断变量是不是存在
SET AA="TEST VARIABALES"
ECHO %AA%
IF DEFINED AA (calc) ELSE ECHO "VARIABLES is not Exsit!!!!!"
cls

::字符进行比较
SET A="123"
IF %A%=="123" (echo "right!!!!") ELSE echo "Error!!!"
IF NOT %A%==321 (echo "Var a=%A%") ELSE echo "This A Variable is Equal 321"

::从参数来传入值:
if "%1"=="a" echo "Arguments Is a"

::判断文件是不是存在，如果不存在就建立
IF NOT EXIST Republic.txt (echo "Republic" > Republic.txt & echo "Create Successful") ELSE (ECHO "Repubic.txt is Exsit")
