#!/bin/bash
# set 显示调式信息
for i in {1..5}
do
set -x
 echo $i
set +x
done

echo "end"
