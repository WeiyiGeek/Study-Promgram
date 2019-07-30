#!/bin/bash
#自定义格式显示调式信息
DEBUG() {
[ "$_DEBUG" = "on" ] && $@ || :
#前面执行则后面不执行execute. : 脚本中“:”告诉shell不要进行任何操作
}

for i in {1..5}
do
DEBUG echo $i
done
