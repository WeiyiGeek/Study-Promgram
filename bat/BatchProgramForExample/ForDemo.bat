@echo off
color 0A
for %%i in (*) do echo %%i
::For �﷨���б���bat��txtΪ��չ���ļ�������
For %%c in (*.bat *.txt) do type %%c

::For �����ɾ���������ļ�
::for %%a in (*.txt) do echo "����ɾ��%%a" & del /s %%a

::��ʾӲ�̷�����IF��For������Ӧ��
set str=c d e f g h i j k l m n o p q r s t u v w x y z 
echo ��ǰӲ�̵ķ����У� 
for %%i in (%str%) do if exist %%i: echo %%i: 

:
::For /d ��ʾ��ǰĿ¼�µ�Ŀ¼
for /d %%i in (*) do @echo %%i  


::For /R ��ʾ��ǰĿ¼�µ�Ŀ¼�����ļ�(Recurision��ݹ�)
for /r f:\rep %%i in (*) do @echo %%i  
color 0B
for /r %%i in (*) do @echo %%i  


::for /l ��ֵ�����ݼ�
for /l %%i in (1,1,5) do echo %%i
for /l %%i in (1,1,3) do calc


::For /F �����ַ���ȡ������
for /f %%i in (test.txt) do echo %%i


::For /F ���޶������������зֽ�
for /f "delims=��" %%i in (test.txt) do echo %%i 


::For /F ���޶���������ѡ����ʾ�ֽڵ�����
for /f "tokens=2 delims=.��" %%i in (test.txt) do echo %%i 
for /f "tokens=2,5  delims=��" %%i in (Test1.txt) do echo %%i %%j


::��ʾ��������ָ���ֽ�or֮���ȫ���ֽ�
for  /f  "delims=��  tokens=1,2,3,4,5"  %%i  in  (test1.txt)  do echo %%i %%j %%k %%l %%m 
::Ч��ͬ��
for /f "delims=�� tokens=1,*" %%i in (test1.txt) do echo %%i %%j
for /f "delims=��  tokens=1,2-4,*" %%i in (test1.txt) do echo %%i %%j %%k %%m


::For�ĸ߼����ÿ��Էָ�ip��ַ��˿�
for /f "delims=:" %%i in (ip.txt) do echo ��ȡ����IP��ַ��:%%i
for /f "delims=: tokens=2" %%i in (ip.txt) do echo ��ȡ����Port��:%%i


::��Ծָ��������,N+1��ʼ��ʾ
for /f "skip=2" %%i in (test.txt) do echo %%i 


::����Ingoreָ���ַ�Ϊ��ͷ����
for /f "eol=��" %%i in (test.txt) do echo %%i 


::ִ��Command�����浽�ڴ��ļ���ʽ��,Ȼ����for���ж�ȡ
for /f %%i in ('dir /a-d/b *.*') do echo %%i  

::�ı��ַ�������ķָ����
for /f "delims=. tokens=1-3" %%i in ("bbs.bathome.cn") do echo %%i-%%j-%%k 

::����usebackqѡ����ж�ȡ�����ļ���
for /f "usebackq" %%i in ("test 1.txt") do echo %%i 































































