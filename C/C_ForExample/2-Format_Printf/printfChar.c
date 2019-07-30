#include <stdio.h>

int main(){

	printf("打印5个字符:%c %c %c %c %c\n",70,105,115,104,67);
	printf("前面用 填充:%10d\n",2015);
	printf("前面用0填充:%010d\n",2015);
	printf("右对齐 , 保留2位:%10.2f\n",3.1416);
	printf("左对齐 , 保留3位:%-10.3f\n",3.1416);
	printf("右对齐 , 指数e:%10e\n",520000.0);
	printf("左对齐 , 指数E:%-10E\n",520000.0);
	return 0;
}
