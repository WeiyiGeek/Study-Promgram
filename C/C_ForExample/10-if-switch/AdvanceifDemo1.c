#include <stdio.h>

int main(){
	int a,b;
	/*
	printf("������a��ֵ:");
	scanf("%d",&a);
	printf("������a��ֵ:");
	scanf("%d",&b);*/ 
	
	printf("������a��b��ֵ:");
	scanf("%d-%d",&a,&b); //scanf������ַ�������Ϊ����ķָ���� 
	if (a != b){
		if (a > b){
			printf("a�Ǵ���b��:%d > %d \n",a,b);
		}else{
			printf("a��С��b��:%d < %d \n",a,b);
		}
		
	}else{
		printf("a�ǵ���b�ģ�%d = %d",a,b);
	}
	return 0; 
}

