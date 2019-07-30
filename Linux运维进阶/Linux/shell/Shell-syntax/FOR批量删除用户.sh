#!/bin/bash

for i in $(cat /etc/passwd | grep "/bin/bash" | grep -v root | cut -d ":" -f 1) 
	do
		/usr/bin/userdel -r $i
	done