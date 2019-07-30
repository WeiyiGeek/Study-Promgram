#include <stdio.h>
#include <stdlib.h>
#define MAX 1024

int main(void)
{	
	FILE *fp;
	char buffer[MAX];
	if((fp = fopen("read_hello.txt","w")) == NULL)
	{
		printf("打开文件失败！\n");
		exit(EXIT_FAILURE);
	}
	fputs("Line one : Hello World!\n", fp);
	fputs("Line two : C language\n", fp);
	fputs("Line there : I love study network technology!\n", fp);

	fclose(fp);
	//写归写,读归读,重新使用上面的文件指针

	if((fp = fopen("read_hello.txt","r")) == NULL)
        { 
                printf("打开文件失败！\n");
                exit(EXIT_FAILURE);
       	}
	//feof 返回0，说明没有到末尾
	while(!(feof(fp)))
	{
	fgets(buffer, MAX, fp); //由于读第三行的时候文件末尾是\n而不是EOF,所以就是该函数返回值的第二点，任然返回上一个buffer的地址所以输出了两次
	printf("%s", buffer);
	}
	
	fclose(fp); //又忘记了,哎
	return 0;
}
