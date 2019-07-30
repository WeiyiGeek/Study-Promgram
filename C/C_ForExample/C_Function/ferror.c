#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE *fp;
	int ch;
	if(( fp = fopen("text.txt","w")) == NULL)
	{
		printf("打开文件失败！..\n");
		exit(EXIT_FAILURE);
	}
	
	ch = getc(fp);
	if(ferror(fp))
	{
		perror("原因是：");
		printf("读取文件text.txt失败！..\n");
	} 
		
	fclose(fp);
	
	return 0;
	
}
