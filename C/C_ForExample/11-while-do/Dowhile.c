#include <stdio.h>

int main(){
	
	int i=1,sum=0;
	do{
		sum = sum + i;
		i+=1;
	}while(i<=100);
	printf("1�ӵ�100����:%d",sum);
	return 0;
}
