#!/bin/bash

if [ ${#} == 0 ]
then
	echo "useage:${0} file.c"
else
	gcc ${1} -o ${1}c && ./${1}c
fi
