#include <stdio.h>

#define PI 3.14159
#define S(r) PI*r*r
#define C(r) 2*PI*r

int main(){
	int r = 5;
	printf("�뾶��%d��Բ,���������%.2f,�����ܳ���%.2f\n",r,S(r),C(r));
	return 0;
	
} 
