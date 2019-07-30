#!/bin/bash
#进制的转换要转换的进制,现在的进制将要转换进制的值

if [ $# = 0 ];then
        echo "usage:${0} outputbase inputbase jzvalue"
else
        oubase=$1
        inbase=$2
        value=$3
        echo "obase=${oubase};ibase=${inbase};${value}" | bc
fi
