#include <stdio.h>
#include <string.h>

int main(){

	char str1[] = "Hello,World C Pragrams!";
	char str2[40];
	char str3[40];

	strncpy(str2,str1,sizeof(str2)); //sizeof大小为40
	strncpy(str3,str1,5); //取5个字符hello
	str3[5] = '\0';
	
	printf("str1=%s\n\n", str1);
        printf("str2=%s\n", str2);
        printf("str3=%s\n", str3);

}

