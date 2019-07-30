#include <stdio.h>
#include <math.h>

int main(){
	int i,j,sum=4;
	for(i=9;i<=10000;i++){

		for(j=2;j<=sqrt(i);j++){
			if(i % j == 0){
					sum +=1;
					break;		
			}
		}
	}
	printf("10000以内的素数的个数是%d个\n",10000-sum);
	return 0;	
}
