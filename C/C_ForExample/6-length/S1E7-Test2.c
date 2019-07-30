#include <stdio.h>
#include <math.h>
 
int main(){
	
	int i;
	double result;
	
	printf("请输入一个整数:");
	scanf("%d",&i);
	
	result = pow(i, 5);
	printf("%d的五次方是:%.2f",i,result);

	return 0;
} 
