#!/bin/bash

echo -e "\e[1;32m #精密计算bc\e[0m"
a=$1
b=$2
echo "bc精密计算a=:`echo "$a"|bc`"
echo -e "bc精密计算b=:`echo "$b"|bc` \n"
echo "bc精密计算a+b=:`echo "$a+$b"|bc`"
echo "bc精密计算a/b=:`echo "$a/$b"|bc`"
echo -e "bc精密计算a*b=:`echo "$a*$b"|bc`\n"

echo -e "\e[1;33m #scale设定小数精度（数值范围）\e[0m"
echo "scale设置小数3位精度a/b:`echo "scale=3;$a/$b"|bc`"
echo "scale设置小数3位精度a*b:`echo "scale=10;$a*$b"|bc`"
