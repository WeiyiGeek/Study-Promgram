#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE *fp;
	int year, month, day;

	if((fp = fopen("time.txt","a+")) == NULL)
	{
		printf("打开文件失败！\n");
		exit(EXIT_FAILURE);
	}	
	
	printf("从文件中读取的时间 ：\n");
	fscanf(fp,"%d-%d-%d", &year, &month, &day);
	printf("%d-%d-%d\n", year, month, day);
	fclose(fp);
	return 0;
}
