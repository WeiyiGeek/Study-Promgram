#include <stdio.h>
#include <stdlib.h>

int main(){
	FILE *fp;
	int ch; 

	if((fp = fopen("text.txt","a+")) == NULL){
		printf("OPen file Fail!");
		exit(EXIT_FAILURE);
	}
	

	while((ch = getchar()) != '\n'){
		fputc(ch,fp);
	}
	fputc('\n',fp);
	fclose(fp);

	return 0;
}