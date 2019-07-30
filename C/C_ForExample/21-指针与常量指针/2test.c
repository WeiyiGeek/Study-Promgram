#include <stdio.h>

int main(){
	int num = 520;
	const int cnum = 1024;
	int * const p = &num; // 定义的一个指针常量

	*p = 2048;
	//p = &num; // 这是被禁止的,由于我们是常量指针（不再是指针变量了）  
	printf("*p: %d, p: %p\n", *p, p);


}
