#include <stdio.h>

int test_func(int taskid,char event)  //����һ������
{
	printf("int test_f
	unc taskid:%d\tevent:%c\n",taskid,event);
}

typedef int (*test_func_tdf)(int taskid,char event);  //��������ָ��

void main(void){
	test_func_tdf test_func_r = test_func; //����ָ�� test_func_tdf ָ���˺��� test_func_r
	test_func(1923,'c');
	test_func_r(1997,'d');
}
