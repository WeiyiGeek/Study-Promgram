#include <stdio.h>

int main(){
	char str[] = "I love qq.com";
	char *target = &str[0];
	
	int count = 0;
	
	//while(*str++ != '\0')  ����str��һ����������������Ϊlvalue  
	while(*target++ != '\0'){   // *ȡֵ target����Ҫע�����++ �ڱ���ִ�о���target����,����Ч����һ�β���target+1. 
		count++;
	}
	
	printf("���ι������ %d ���ַ�!\n",count);
	return 0; 
}

