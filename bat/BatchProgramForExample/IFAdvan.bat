@ECHO OFF
::�жϱ����ǲ��Ǵ���
SET AA="TEST VARIABALES"
ECHO %AA%
IF DEFINED AA (calc) ELSE ECHO "VARIABLES is not Exsit!!!!!"
cls

::�ַ����бȽ�
SET A="123"
IF %A%=="123" (echo "right!!!!") ELSE echo "Error!!!"
IF NOT %A%==321 (echo "Var a=%A%") ELSE echo "This A Variable is Equal 321"

::�Ӳ���������ֵ:
if "%1"=="a" echo "Arguments Is a"

::�ж��ļ��ǲ��Ǵ��ڣ���������ھͽ���
IF NOT EXIST Republic.txt (echo "Republic" > Republic.txt & echo "Create Successful") ELSE (ECHO "Repubic.txt is Exsit")
