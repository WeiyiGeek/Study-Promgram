#include <stdio.h>

#define URL "http://www.baidu.com"
#define NAME "C语言学习"
#define BOSS "Weiyi"
#define YEAR 2017
#define MONTH 10
#define DAY 9

int main(){
	printf("我当前正在浏览%s,进行%s,我的名字%s\n",URL,NAME,BOSS);
	printf("当前时间是:%d-%d-%d",YEAR,MONTH,DAY);
	return 0;
}

