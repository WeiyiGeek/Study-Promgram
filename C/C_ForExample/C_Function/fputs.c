#include <stdio.h>
#include <stdlib.h>

int main(){
	FILE *fp;
	
	if((fp = fopen("text.txt","w")) == NULL){
		printf("打开文件失败！\n");
		exit(EXIT_FAILURE);
	}

	fputs("I'd like to study C language!\n",fp);
	fclose(fp);

	return 0;
}
