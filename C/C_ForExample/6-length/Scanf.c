#include <stdio.h>

int main(){
	char a;
	int b,c,d;
	printf("请输入a,b,c,d的值:");
	scanf("%c %d %d %d",&a,&b,&c,&d);
	printf("a的字符是:%c\n",a);
	printf("b的八进制数:%#o\n",b);
	printf("c的十进制数:%d\n",c);
	printf("d的十六进制数:%#X\n",d);
	
	return 0;
}
