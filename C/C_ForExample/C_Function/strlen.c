#include <stdio.h>
#include <string.h>

int main(){

	printf("字符串常量长度:%d\n",strlen("test Strlen"));

	char stra[] = "I love Study C Pragram!";
	char strb[20] = "C++";
	printf("straLength = %u\n",strlen(stra));
	printf("strbLength = %u\n",strlen(strb));
	
}
