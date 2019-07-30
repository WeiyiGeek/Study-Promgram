#include <stdio.h>

int main(){
	char str[123];
	printf("请输入一串字符:");

	scanf("%s",str);
	
	printf("str的地址是:%p\n",str);
	printf("&str[0]的地址是:%p\n",&str[0]);
}
