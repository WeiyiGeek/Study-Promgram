#include <stdio.h>

int main(){
	int a = 5; // 0101 
	int b = 3; // 0011
	
	printf("5&3������:%d\n",a & b); //0001 ͬ��Ϊ�� 
	printf("5|3������:%d\n",a | b); //0111 һ��Ϊ�� 
	printf("5^3�������:%d\n",a ^ b);  //0110 ͬ0��1Ϊ��,��Ϊ�� 
	return 0;
}

