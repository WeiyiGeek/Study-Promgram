#include <stdio.h>
#include <string.h>

int main(){
	int i,len;
	char str[]="Hello World!"; //array
	char * rev_string;   //ָ��
	len=strlen(str);    //��ȡ�ַ����ĳ���
	rev_string=(char *)malloc(len+1);  //�����ݿռ��ַ��+1
	printf("%s\n",str);
	for(i=0;i<len;i++)
		rev_string[len-1-i]=str[i];
	rev_string[len+1]='\0';
	printf("The Reverse String is %s \n",rev_string);
	return 0;
}
