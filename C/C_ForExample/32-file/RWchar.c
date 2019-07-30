#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE *fpr;
	FILE *fpw;
	int ch;
	//先读取一个文件
	if((fpr = fopen("read_hello.txt","r")) == NULL)
	{
		printf("文件打开失败!!!\n");
		exit(EXIT_FAILURE);
	}
	
	//再打开写入的文件
	if((fpw = fopen("write_hello.txt","w")) == NULL)
        { 
                printf("文件打开失败!!!\n");
                exit(EXIT_FAILURE);
       	}
	//EOF 宏定义 === END OF FILE
	while((ch = fgetc(fpr)) != EOF){
		//将获取的字符写入文件之中
		fputc(ch, fpw); //字符, 文件指针
		
	}
	//关闭文件是非常重要的
	fclose(fpr);
	fclose(fpw);
	return 0;
}
