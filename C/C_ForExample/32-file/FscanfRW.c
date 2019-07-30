#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void)
{	
	FILE *fp;
	struct tm *p;
	time_t t;
	
	time(&t);
	p = localtime(&t);
	
	if((fp = fopen("date.txt","w")) == NULL)
	{
		printf("打开时间失败！");
		exit(EXIT_FAILURE);
	}
	fprintf(fp, "%d-%d-%d", 1900 + p->tm_year, 1 + p->tm_mon, p->tm_mday);
	fclose(fp);
	
	//C语言可以随处申请变量的
	int year, month, day;
	if((fp = fopen("date.txt","r")) == NULL)
	{
		printf("打开时间失败！");
                exit(EXIT_FAILURE);
	}

	fscanf(fp, "%d-%d-%d", &year, &month, &day);
	printf("插入的当前时间 ：%d-%d-%d\n", year, month, day);
	fclose(fp); //重要

	return 0;
}

