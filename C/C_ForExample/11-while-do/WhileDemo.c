#include <stdio.h>

int main(){
	int i=1,sum=0;
	
	while(i<=100){
		sum = sum +i;
		i+=1;
	}
	printf("从1加到100等于:%d",sum); 
	return 0;
}

