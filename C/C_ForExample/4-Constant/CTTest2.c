#include <stdio.h>

#define PI 3.14159
#define S(r) PI*r*r
#define C(r) 2*PI*r

int main(){
	int r = 5;
	printf("半径是%d的圆,它的面积是%.2f,它的周长是%.2f\n",r,S(r),C(r));
	return 0;
	
} 
