# Linux - Shell

脚本测试与编写,及其基本语法

**#shell-If语句** 

一.单分支语句
```
if [[ xxx ]];then
	echo ""
fi
```


二.双分支语句
```
if [[ xxx ]];then
	echo ""
else
	echo ""
fi
```

三.多分支语句
```
if [[ xxx ]];then
	echo ""
elif [[ xxx ]];then
	echo ""
elif [[ xxx ]];then
	echo ""
else
	echo ""
fi
```

 **#shell-case语句** 

1.Case多分支语句

```
Case $echo in
	"1")
		echo "1"
		;;
	"2") 
		echo "1"
		;;
	*) 
		echo "*"
		;;
esac
```

**#shell-for循环语句** 
```

1.for 变量 in 值1 值2 值3
	do
		$变量
	done
	
for i in $(cat number.txt)
	do
		echo $i
	done
```
	

```
2.for(( 初始值;循环控制;变量变化 ))
	do 
		程序
	done
	
for((i=1,j=7;i<=7;i++,j--))
do
	echo $i;$j
	echo $[$i+$j]
done
```

 **#shell-While 循环控制** 
```
条件满足则"一直循环"

while [ 条件控制判断 ]
	do
		程序
	done

```
 **#shell-Until 循环控制** 
```
条件满足则"结束循环"

until [ 条件控制判断 ]
	do
		程序
	done
```
	

 **# Break 与 Contiune** 

Break 跳出循环

Contiune 跳出当前循环,进入下一次循环.

**# Shell函数 Function** 
```

Hello (){
	echo "Hello World!! Linux Shell!!"
}

调用 Hello Function
Hello 
```

输出参数
```
FunArguments (){
	echo "This is Arguments:$1 ${10}"
}

FunArguments 1 10

```

