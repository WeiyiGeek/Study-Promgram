#!/bin/bash

user=$(env | grep "USER" | cut -d "=" -f 2)

#echo $user

if [ "$user" == "root" ];then
	echo "Now user is Root"
fi
