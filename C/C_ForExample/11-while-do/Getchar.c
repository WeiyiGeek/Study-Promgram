#include <stdio.h>

int main(){
	int count = 0;
	printf("������һ���ַ�:");
	
	 //getchar(); //��ȡ�ַ� 
	while(getchar() != '\n'){
		count+=1;
	}
	printf("��������ܵ��ַ���Ϊ:%d",count);
} 
