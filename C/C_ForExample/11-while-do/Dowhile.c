#include <stdio.h>

int main(){
	
	int i=1,sum=0;
	do{
		sum = sum + i;
		i+=1;
	}while(i<=100);
	printf("1加到100等于:%d",sum);
	return 0;
}
