#include <stdio.h>
#include <stdlib.h>
#define BUFFER_SIZE 1024

int main(int argc,char **argv)
{
	FILE *fpfrom,*fpto;
	char buf[BUFFER_SIZE] = {0};
	int length = 0; //统计字符数
	
	//检查参数是否输入正确
	if(argc != 3){
		printf("Usage:%s FileFrom FileTo\n",argv[0]);
		exit(1);
	}

	//打开要复制的源文件
	if((fpfrom = fopen(argv[1],"r+b")) == NULL){
		printf("Failure OPEN %s\n",argv[1]);
		exit(2);
	}
	
	//打开要复制到的目标文件
	if((fpto = fopen(argv[2],"w+b")) == NULL){
		printf("Failure OPEN %s\n",argv[2]);
		exit(3);
	}

	while((length = fread(buf,1,BUFFER_SIZE,fpfrom)) > 0){  //当length小于等于0则读到文件尾
		fwrite(buf,1,length,fpto);
	}
	printf("已将 %s 复制为 %s\n",argv[1],argv[2]);
	fclose(fpfrom);
	fclose(fpto);

	return 0;
}
