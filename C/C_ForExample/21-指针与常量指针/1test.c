#include <stdio.h>

int main(){
	int num = 520;
	const int cnum = 1024;
	const int *pc = &cnum;

	printf("cnum: %d, &cnum: %p\n",cnum,&cnum);
	printf("*pc: %d, pc: %p\n",*pc,pc);
	
	//*pc = 2048;

	pc = &num;  //但可以修改指针指向的地址
	printf("\nnum: %d, &num: %p\n", num, &num);
	printf("*pc: %d, pc: %p\n", *pc, pc);

	num = 2048;  //可以修改未设置const的变量,来修改*pc
	printf("\n*pc: %d, pc: %p\n", *pc, pc);
	return 0;
}
