#include <stdio.h>

int test_func(int taskid,char event)  //声明一个函数
{
	printf("int test_f
	unc taskid:%d\tevent:%c\n",taskid,event);
}

typedef int (*test_func_tdf)(int taskid,char event);  //建立函数指针

void main(void){
	test_func_tdf test_func_r = test_func; //函数指针 test_func_tdf 指向了函数 test_func_r
	test_func(1923,'c');
	test_func_r(1997,'d');
}
