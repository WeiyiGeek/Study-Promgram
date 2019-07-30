#!/bin/bash
#Base64 Encrpty/Decrpty

exec 3<>pass.txt
while read line<&3
do
	echo $line | base64
done

for i in $(cat en.txt)
do
	echo $i | base64 -d 1>>de.txt 2>/dev/null
	echo -e "" >> de.txt
done
