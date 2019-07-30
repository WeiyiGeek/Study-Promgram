#include <stdio.h>
#include <math.h>

int main(){
	int a,b,sum=0;
	for(a=1,b=2;a<=5;a++){
		sum = pow(a, b) + sum;
		b += 1;
	}
	printf("1^2+2^3+3^4+4^5+5^6=%d\n",sum);

    int result;
    result = pow(1, 2) + pow(2, 3) + pow(3, 4) + pow(4, 5) + pow(5, 6);
	printf("½á¹ûÊÇ£º%d\n", result);
 	return 0;	
}
