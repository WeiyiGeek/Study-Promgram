#!/bin/bash

#提取SDA硬盘容量大小的百分比值
diskfile=$(df -h | grep "/dev/sda" | awk '{print $5}' | cut -d "%" -f 1)
echo $diskfile

#将/分区变量付给 diskfile
if [ "$diskfile" -ge "90"  ];then
		echo "/ is full"
fi

