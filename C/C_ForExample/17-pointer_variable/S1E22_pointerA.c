#include <stdio.h>
#include <string.h>
int main(){
	char *str = "I love fisch.com!";
	int i,length;

	length = strlen(str);
	for(i=0 ; i< length ; i++){
		printf("%c-",str[i]);
	}
	putchar('\n');
	return 0;
}