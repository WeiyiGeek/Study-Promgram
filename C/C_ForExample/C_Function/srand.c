#include <stdio.h>
#include <stdlib.h>

int i;
void test(void);

void test(void){
	for(int x = 0; x < 10; x++){
	i = rand() % 2;
	printf("�������%d\n", i);
	}
}

int main(void){
	srand(1);
	test();	
	return 0;
}
