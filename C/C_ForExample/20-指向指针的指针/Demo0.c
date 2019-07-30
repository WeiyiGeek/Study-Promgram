#include <stdio.h>

int main(){
	int num = 520;
	int *p = &num;
	int **pp = &p;
	
	printf("number:%d\n",num);
	printf("*P:%d\n",*p);
	printf("**p:%d\n",**pp);
	
	printf("/*****利用内存地址表示*****/\n");
	printf("&p：%p, pp: %p\n",&p,pp);
	printf("&num: %p, p: %p, *pp： %p\n",&num,p,*pp);
	
	return 0;
} 


