#include <stdio.h>

int main(){
	int a,b;
	/*
	printf("请输入a的值:");
	scanf("%d",&a);
	printf("请输入a的值:");
	scanf("%d",&b);*/ 
	
	printf("请输入a与b的值:");
	scanf("%d-%d",&a,&b); //scanf里面的字符可以作为输入的分割符号 
	if (a != b){
		if (a > b){
			printf("a是大于b的:%d > %d \n",a,b);
		}else{
			printf("a是小于b的:%d < %d \n",a,b);
		}
		
	}else{
		printf("a是等于b的：%d = %d",a,b);
	}
	return 0; 
}

