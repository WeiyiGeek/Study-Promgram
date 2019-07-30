#!/bin/bash

read -t 30 -p "Please input a dir:" tdir

if [ -d "$tdir"];then
	echo "directory is exist"
else
	echo "directory not exist"
fi

