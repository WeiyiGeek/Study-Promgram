#include <stdio.h>

int main(){
	int a=4,b=2;
	printf("Please input seconde number\n");
	a -= 2;
	printf("a=%d\n",a);
	
	b +=3;
	printf("b=%d\n",b);

	a /= 2;
	printf("a=%d\n",a);

	b %= 4;  // 注意这里必须是 整形输出(%d) 且 b变量类型也得为int
	printf("b=%d\n",b);

	return 0;
}
