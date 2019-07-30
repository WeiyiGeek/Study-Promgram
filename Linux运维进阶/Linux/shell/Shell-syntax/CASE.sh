#!/bin/bash
#case 多分支语句
echo 'Input a number between 1 to 4'
echo  -e 'Your number is:\c'
read aNum
case $aNum in
        1)  echo -e 'You select 1\n'
        ;;
        2)  echo -e 'You select 2\n'
        ;;
        3)  echo -e 'You select 3\n'
        ;;
        4)  echo -e 'You select 4\n'
        ;;
        *)  echo -e 'You do not select a number between 1 to 4'
        ;;
esac

#新颖的思路可以利用这个来写小脚本
option="${1}"
case ${option} in
       -f) FILE="${2}"
          echo "File name is $FILE"
          ;;
       -d) DIR="${2}"
          echo "Dir name is $DIR"
          ;;
       *) 
          echo "`basename ${0}`:usage: [-f file] | [-d directory]"
          exit 1 # Command to come out of the program with status 1
          ;;
esac
