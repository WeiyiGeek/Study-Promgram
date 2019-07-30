#include <stdio.h>
#include <string.h>

int main(){
	int i,len;
	char str[]="Hello World!"; //array
	char * rev_string;   //指针
	len=strlen(str);    //获取字符串的长度
	rev_string=(char *)malloc(len+1);  //在数据空间地址上+1
	printf("%s\n",str);
	for(i=0;i<len;i++)
		rev_string[len-1-i]=str[i];
	rev_string[len+1]='\0';
	printf("The Reverse String is %s \n",rev_string);
	return 0;
}
