#!/bin/bash
#进制之间的转换 B->O->D->H
read -p "Please INput NUmeric:" abc
echo -e "\e[1;33;5m 进制转换结果 \e[0m"
echo "二进制(BIN):`echo "obase=2;$abc"|bc`"
echo "八进制(OCTAL):`echo "obase=8;$abc"|bc`"
echo "十进制(DEC):`echo "obase=10;$abc"|bc`"
echo "十六进制(HEX):`echo "obase=16;$abc"|bc`"

