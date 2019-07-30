#!/bin/bash
#Printf里的进制转换
#Printf里的Ascll编码
exec 4<>test.txt
while read line<&4
do
	echo -e "\e[1;37;5m 数据进行转换: \e[0m"
	printf "%-10s \n" Octal-Dec-hex:
	printf "%-10o" $line 
	printf "%-10d" $line
	printf "%-10x \n" $line
done

##Octal -> ASCLL(123456789)
echo -e "\e[1;36m Octal-> Ascll\e[0m"
for i in 60 61 62 63 64 65 66 67 70 71
do
        printf "Octal=$i,Ascll=\\$i \n"
done

##Hex -> ASCLL(123456789)
echo -e "\e[1;36m Octal-> Ascll\e[0m"
for hex in 60 61 62 63 64 65 66 67 70 71
do
        printf "Octal=$hex,Ascll=\x$hex \n"
done