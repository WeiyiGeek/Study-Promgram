#include <stdio.h>

int main(){
	int array[4][5] = {0};

	printf("sizeof int : %d \n",sizeof(int));
	printf("Array: %p\n",array);
	printf("Array + 1: %p\n",array +1);

	return 0;
}
