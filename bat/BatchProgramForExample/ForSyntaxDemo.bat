@echo off
::For �﷨���б���bat��txtΪ��չ���ļ�������
for %%c in (*.bat *.txt) do type %%c
::For �����ɾ���������ļ�
for %%a in (*.txt) do echo "����ɾ��%%a" & del /s %%a
