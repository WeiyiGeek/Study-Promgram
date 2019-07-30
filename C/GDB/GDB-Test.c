#include <stdio.h>

int sum(int n);
main(){
	int s = 0;
	int i,n;
	for(i=0; i<=50; i++){
		s = s + i;
	}
	s = s + sum(20);
	printf("the result is %d \n",s);
}


int sum(int n){
	int total = 0;
	int i;
	for(i=0; i<=n; i++){
		total = total + i;
	return (total);
	}
}
