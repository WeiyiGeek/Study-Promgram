#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	FILE *fp;
	char buff[1024];
	memset(buff,'\0',sizeof(buff));
	//指定标准输出流stdout，全缓存
	//如果是_IONBF 则是没有缓冲区，直接打印或者写入到文件之中
	setvbuf(stdout, buff, _IOFBF, 1024);

	fprintf(stdout,"Welcome to study C language!\n");
	fflush(stdout); //直接刷新缓冲区,然后标准输出到屏幕之上
	fprintf(stdout,"输入字符才显示该段文字！\n");
        getchar();

	if((fp = fopen("output.txt","w")) == NULL)
	{
		fprintf(stdout,"打开失败：");
		exit(EXIT_FAILURE);
	}

	fputs("I love Fishc.com!!\n",fp);
	
	fflush(fp); //直接刷新缓冲区,不用输入字符也能写入文件中（不会在执行阻塞函数后才写入字符串）
	
	getchar(); //这是一个阻塞函数,输入字符后才能显示上面的字符串(然而上面的fflush不会等这么长的时间，在未关闭文件的条件下将缓冲区写入到文件中)	

	fclose(fp);	
	return 0;
}
