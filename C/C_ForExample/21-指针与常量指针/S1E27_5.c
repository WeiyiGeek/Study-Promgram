#include <stdio.h>

int main(){
	int num = 520;
	const int *p = &num;
	const int * const *q = &p;
	printf("%d\n", **q);

	return 0;
}
