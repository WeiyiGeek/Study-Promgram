#include <stdio.h>

int main(void)
{
	enum Color {red = 10, green, blue};  //10, 11, 12;
	enum Color rgb; //枚举变量
	//如果我对于中间某一枚举名称赋指定的值,下面的效果
	enum Head {first, seconde, three=6, four};   //0, 1 , 6, 7

	//枚举变量支持自增运算，而C++是不支持的
	for(rgb = red; rgb <= blue; rgb++)
	{
		printf("rgb = %d \t",rgb);
	}
	putchar('\n');
	//枚举常量的名称与值，是在编译的时候就关联在一起了,一旦确定下来他就是一个常量，无法修改
	//如果我们现在给枚举名称指定值.那他将报错。lvalue
	//green = 15;

	printf("First of value: %d\n", first);
	printf("seconde of value: %d\n", seconde);
	printf("three of value: %d\n", three); //两面π
	printf("four of value: %d\n", four);
	return 0;
}
