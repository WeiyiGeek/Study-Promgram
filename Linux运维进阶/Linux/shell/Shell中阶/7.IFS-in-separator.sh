#!/bin/bash
data="111,222,333,444,555,666"
oldIFS=$IFS  #定义一个变量为默认IFS
IFS=,        #设置IFS为逗号
for i in $data
do
 echo S:$i
done
IFS=$oldIFS  #还原IFS为默认值
