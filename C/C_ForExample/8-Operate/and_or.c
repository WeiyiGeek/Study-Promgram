#include <stdio.h>

int main(){
	int a = 5; // 0101 
	int b = 3; // 0011
	
	printf("5&3与运算:%d\n",a & b); //0001 同真为真 
	printf("5|3或运算:%d\n",a | b); //0111 一真为真 
	printf("5^3异或运算:%d\n",a ^ b);  //0110 同0，1为假,异为真 
	return 0;
}

