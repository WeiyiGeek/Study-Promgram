#!/bin/bash
#命令执行效率
start=$(date +%s) 
#start=`date +%s`,等号不能有空格，如果有空格，会被变量当成命令
for(( i = 0; i <5 ; i++ ));do
	echo $i >/dev/nulli
	sleep 1
done
end=`date +%s`
diff=$(($end-$start))
echo "use times(ms):"$diff
echo "use times(ms):"$(($end-$start))
