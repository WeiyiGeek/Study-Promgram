#include <stdio.h>
#include <stdlib.h>
#define MAX 1024

int main(){
	FILE *fp;
	char str[MAX];
	char buf[MAX];

	if((fp = fopen("./fgets.txt","r+")) == NULL){
		sprintf(buf,"%s\n","打开文件失败！");
		printf("%s",buf);
		exit(1);
	}
	printf("请输入一个字符串:");
	fgets(str,MAX,stdin);
	printf("你输入的内容是:%s\n",str);
	
	fgets(str,13,fp);
	printf("读取的数据为:%s\n",str);
	
	fclose(fp);
	return 0;

}
