@echo off
::��ȡ�ַ���Demo
cls
set ifo=0123456789-ABCDEFGHIJKLMNOPQRSTUVWXYZ-abcdefghijklmnopqrstuvwxyz
echo �ַ���Demo:%ifo%
echo [Demo1]
echo ��ȡǰ10���ַ���
echo %ifo:~0,10%
echo [Demo2]
echo ��ȡ��26���ַ���
echo %ifo:~-26%
echo [Demo3]
echo ��ȡ�ӵ�10���ַ���ʼ(10+1)-����ȡ27���ַ���
echo %ifo:~10,27%
echo [Demo4]
echo ��ȡ�ӵ�23���ַ���ʼ(13+1)��ȡ����13���ַ���
echo %ifo:~23,-13%
echo [Demo5]
echo ��ȡ�ӵ�23���ַ���ʼ(13+1)��ȡ������ĺ��ַ���
echo %ifo:~23%
echo [Demo6]
echo ��ȡ�Ӻ�����53���ַ���ʼ(53),Ȼ������ȡ���ò�������ȡ26���ַ���
echo %ifo:~-53,26%
pause
