#include <stdio.h>

int main(){
	int a = 123;
	char b = 'W';
	
	int *pa = &a;  //pointer初始化,注意数据类型
	char *pb = &b;  //取地址运算符

	printf("pointer_a = %d\n",*pa); //取值运算符
	printf("pointer_b = %c\n",*pb);

	
	*pa += 1; //指针变量的赋值操作
	*pb = 'Y';
	putchar('\n');

	printf("add,*pa = %d\n",*pa);
	printf("add,*pb = %c\n",*pb);
	
	putchar('\n');

	printf("Sizeof(pa) = %dB\n",sizeof(pa)); //空间长度都为4B
	printf("Sizeof(pb) = %dB\n",sizeof(pb)); //不论数据类型
	
	putchar('\n');

	printf("pa指针变量内存地址:%p\n",pa);  //%p是指针在内存中的地址输出的占位符号
	printf("pb指针变量内存地址:%p\n",pb);

}

