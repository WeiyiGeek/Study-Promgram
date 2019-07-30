#include <stdio.h>

int main(){
	int ch;
	printf("请输入一串大小写掺杂的字符:");
	while((ch = getchar()) != '\n'){
		if(ch >= 'A' && ch <= 'Z'){
			putchar(ch+32);
		}else if(ch >= 'a' && ch <= 'z'){
			putchar(ch-32);
		}else{
			putchar(ch);	
		}
	}
	printf("\n");

	return 0;

}
