#include <stdio.h>

int main(){

	printf("字符串常量:%s\n","This is a string!");

	char b[] = {"This is b String"};
	char c[50] = "hello,and" "how are" "you";
	//等价于
	//char greeting[50] = "hello,and how are you";
	printf("案例1、数组类型的字符串:%s\n",b);
	printf("案例2、数组类型的字符串:%s\n",c);
	
	char *m = "Hello,world!";
	printf("Char指针的字符串:%s\n",m);
	return 0;
}
