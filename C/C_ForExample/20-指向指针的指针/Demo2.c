#include <stdio.h>

int main(){

	int array[10] = {1,2,3,4,5,6,7,8,9,0};
	int *p = array;
	int i;

	for(i = 0; i < 10;i++){
		printf("%d\t",*(p + i));
	}
	putchar('\n');
}
