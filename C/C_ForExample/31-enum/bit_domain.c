#include <stdio.h>

int main(void)
{
	struct Bit
	{
		unsigned int a:32;
		unsigned int b:1;
		unsigned int c:2; //注意只能存储坑位大小的数据否则报错
	};

	struct Bit bit;
	bit.a = 1; // 0或者1,注意不能超出坑位大小否则输出值是不正确的
	bit.b = 1;
	bit.c = 3; // 00 - 11 二进制表示的位 （0 - 3）
	
	printf("a = %d, b = %d, c = %d\n", bit.a, bit.b, bit.c);
	printf("size of Bit = %d\n", sizeof(struct Bit)); //3个整型变量却只占用了一个整型变量的空间
	
	return 0;
}
