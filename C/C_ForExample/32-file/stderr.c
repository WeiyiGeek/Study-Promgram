#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

int main(void)
{
	FILE *fp;
	int ch;
	if((fp = fopen("date1.txt","r")) == NULL)
	{
		perror("产生错误：");
		putchar('\n');
		printf("错误ID：%d, 错误详情 ：%s\n",errno,strerror(errno));
		exit(EXIT_FAILURE);
	}
	//do some code
	
	fputc('W',fp);
	if(ferror(fp))
	{
		fprintf(stderr,"存在错误指示器！\n");
		printf("错误ID：%d, 错误详情 ：%s\n",errno,strerror(errno));

	}

	//清除错误信息
	clearerr(fp);  
	if(ferror(fp)) {
		printf("根本不会执行！\n");
	}
	fclose(fp);
	return 0;
}
