#!/bin/bash
#迁移位置变量,执行一次shift则向下一个位置变量移动
res=0
while [ $# -gt 0 ]
do
  res=`expr $res + $1`
  shift
  echo $1
  echo $2
  echo $3
done
echo "the sum is:$res"
