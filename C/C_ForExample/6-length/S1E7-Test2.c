#include <stdio.h>
#include <math.h>
 
int main(){
	
	int i;
	double result;
	
	printf("������һ������:");
	scanf("%d",&i);
	
	result = pow(i, 5);
	printf("%d����η���:%.2f",i,result);

	return 0;
} 
