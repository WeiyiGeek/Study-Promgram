#include <stdio.h>
#define MAX 1024
int main()
{
	int a = 2, b = 2;
        int cunt;
	char str1 = 'a', str2 = 'b';
	char str[MAX];

	cunt = sprintf(str,"a+b=%d\n",a+b); //输出长度不包含'\0'
	printf("长度为:%d\t字符串为:%s",cunt,str);

	cunt = sprintf(str,"字符拼接:%c%c\n",str1,str2);
	printf("长度为:%d\t字符串为:%s",cunt,str);
}
