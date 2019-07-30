#!/bin/bash
#提取后缀，删除文件名。
 
file_name="text.gif"
echo "$file_name"
suffix=${file_name#*.}
echo suffix is: $suffix

##*与#* 的不同
file_name="text.gif.bak.2012.txt"
echo "$file_name"
suffix=${file_name#*.}
suffix2=${file_name##*.}
echo suffix is: $suffix
echo suffix is: $suffix2
