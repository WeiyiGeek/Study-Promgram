#include <stdio.h>

#define MAX 1024

int main(){
	
	char str1[MAX];
	char str2[MAX];
	
	char *target1 = str1;
	char *target2 = str2;

	printf("Please input String:");
	fgets(str1,MAX,stdin);
	
	printf("--------���ڿ����ַ���---------\n");
	while((*target2++ = *target1++) != '\0'){
		;
	}	
	
	printf("��ӡ���������ַ�����%s\n",str2);
}

