#!/bin/bash
#For circulation Method 1

#一行一行得读取家目录总中.bash开头的文件
for FILE in $HOME/.bash*
do
	echo $FILE
done

#依次输出
for t in 1 2 3 4 5
do
	echo "输出第${t}个数字:$t"
done

#For Method2
sum=0
for((i=0;i<=100;i++))
do
    sum=$[ $sum + $i ]
done
echo "一到一百相加得:$sum"

#批量解压缩
ls *.tar.gz >> gz.log 2>/dev/null
ls *.tgz >> gz.log 2>/dev/null
echo "正在解压缩 : Wait,Please!!"
for i in $(cat gz.log)
    do
	tar -zxf $i &> /dev/null
    done
rm -rf gz.log


