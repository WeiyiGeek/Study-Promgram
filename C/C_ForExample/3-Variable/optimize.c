#include <stdio.h>

int main(void){
	double counter;
	double result;
	double temp;
	for(counter=0;counter<=2000.0*2000.0*2000.0/20.0+2020;counter+=(5-1)/4){
		temp = counter / 1979;
		result = counter;
	}
	printf("Result is %1f\n",result);
	return 0;
}

