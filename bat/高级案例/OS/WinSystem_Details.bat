@echo off
::注意如果是中文模式(GBK)需要更改CMD编码,不是在scheduledtask会加载资源错误
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
echo System Information >> System_Details.txt

echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
systeminfo | findstr /B /C:"OS" > System_Details.txt

echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
echo Hostname >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
hostname >> System_Details.txt

echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
echo Users>> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
net users >> System_Details.txt

echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
echo Route table >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
route print >> System_Details.txt


echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
echo Netstat INformation>> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
netstat -ano >> System_Details.txt

echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
echo Firewall State >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
netsh firewall show state >> System_Details.txt

echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
echo Firewall configuration >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
netsh firewall show config >> System_Details.txt

echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
chcp 437
echo Scheduled tasks >> ScheTask_Details.txt
echo --------------------------------------------------------------------------------------------------- >> ScheTask_Details.txt
schtasks /query /fo LIST /v >> schetask_Details.txt
echo --------------------------------------------------------------------------------------------------- >> ScheTask_Details.txt
chcp 936

echo tasklist >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
tasklist /SVC >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt

echo net start >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
net start >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt

echo driverquery >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
DRIVERQUERY >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt

echo Wmic hotfix >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
wmic qfe get Caption,Description,HotFixID,InstalledOn >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt

echo reg queries - elavated注册查询 >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
reg query HKLM\SOFTWARE\Policies\Microsoft\Windows\Installer\AlwaysInstallElevated
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt

echo reg queries - elavated >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
sc qc Spooler >> System_Details.txt
accesschk.exe -ucqv Spooler >> System_Details.txt
accesschk.exe -uwcqv "Authenticated Users" * >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt

echo upnhosts - elavated >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt
sc qc upnphost >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt

echo End of Script >> System_Details.txt
echo --------------------------------------------------------------------------------------------------- >> System_Details.txt