#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(){
	FILE *fp;
	char *buf="This is a Fwrite Function!\n";	
	int cunt = 6,slen,len;
	
	slen = strlen(buf);
	if((fp = fopen("fwrite.txt","a+")) == NULL){
		printf("OPen file Failure!");
		exit(1);	
	}
	
	while(cunt--){
		len = fwrite(buf,1,slen,fp);
	}
	printf("SUUCESSFUL Length:%d\n",len);
	fclose(fp);
	return 0;
}
