#include <stdio.h>
#include <stdlib.h>

int main(){
	FILE *fp;
	int ch;

	if((fp = fopen("c:\\text.txt","r")) == NULL){
		printf("OPEN FILE Fail ~—~!");
		exit(EXIT_FAILURE);  //返回一个表示十分
	}

	while((ch = getc(fp)) != EOF){
		putchar(ch);
	}

	fclose(fp);
	return 0;

}