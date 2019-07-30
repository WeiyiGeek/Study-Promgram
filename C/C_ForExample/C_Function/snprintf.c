#include <stdio.h>

int main(){
	char buffer[256];
	char *str = "www.baidu.com";
	int cunt;
	cunt = snprintf(buffer,10,str);
	printf("字符为:%s\t长度为:%d\n",buffer,cunt);
	return 0;
}
