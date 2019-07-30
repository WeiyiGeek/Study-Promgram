#include <stdio.h>
#define MAX 1024

int main(){
	char str[MAX];
	printf("请输入一个字符串:");
	fgets(str,MAX,stdin);
	char *pstr = str; 
	char ch;

	int len=0; 
	while(1){
		ch = *pstr++;
		if (ch == '\0'){
			break;
		}
		
		if((int)ch < 0){
			pstr += 2; //跳过两个字节
		}
		len++;

	}
	printf("你输入的字符长度是:%d\n",len-1);
	return 0;

}
