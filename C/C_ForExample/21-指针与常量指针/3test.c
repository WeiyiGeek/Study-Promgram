#include <stdio.h>

int main(){
	int num = 520;
	const int cnum = 1024;
	const int * const p = &cnum; // 定义了一个不能修改的指针常量指向的地址

	num = 2048;
//	*p = 2048;
	printf("*p: %d\n", *p);

//	p = &num;
	printf("*p: %d\n", *p);

}
