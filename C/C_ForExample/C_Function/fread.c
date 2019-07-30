#include <stdio.h>
#include <stdlib.h>
#define MAX 1024

int main(){
	FILE *fp;
	char buffer[1024];
	int count;

	if((fp = fopen("fgets.txt","rb+")) == NULL){
		printf("###open file failure!\n");
		exit(0);
	}
	count = fread(buffer,3,8,fp);
	printf("当前读取并打印的字符：%s\t字符床的长度为:%d\n",buffer,count);
	fclose(fp);
	return 0;
}
