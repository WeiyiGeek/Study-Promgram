#include <stdio.h>

int main(){
	double i,j=0;

	for (i = 10; i > 0; i /= 2){
        j=j+1;
	}
	printf("%.2f",j);

}
