#include <stdio.h>
#include <string.h> 
//利用指针交换ab的值 
void main(void){
	int a = 1;
	int b = 0;

	int *pa = &a;
	int *pb = &b;
	printf("a = %d,b = %d",*pa,*pb);
	
	putchar('\n');
	
	pb = &a;  //采用赋值地址给pb / pa 
	pa = &b;
	printf("a = %d,b = %d,sizeof(pa) = %d \n",*pa,*pb,sizeof(pa));

}


