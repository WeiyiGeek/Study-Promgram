#include <stdio.h>
#include <math.h> 

int main(){
//	int result;
	unsigned int result;
	result = pow(2,32) - 1;
	printf("int数据的长度:%u",result);
	return 0;
}
