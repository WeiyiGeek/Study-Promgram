#include <stdio.h>
#include <string.h>

int main(void)
{

	char buff[1024];
	//初始化缓冲区空间
	memset(buff, '\0', sizeof(buff));
	
	//指定buff 为缓冲区_IOFBF 表示当前缓冲区已满时候在写入stdout 标准输出
	setvbuf(stdout, buff, _IOFBF, 1024);

	fprintf(stdout,"This is bbs.qq.com\n");
	fprintf(stdout,"This output will go into buff\n");

	//fflush 强制将上面的缓存中的内容写入stdout
	fflush(stdout);

	
	fprintf(stdout,"This will waiting .... \n");
	fprintf(stdout,"Will come after sleeping 5 seconds.... \n");
	
	sleep(5);
	return 0;
}
