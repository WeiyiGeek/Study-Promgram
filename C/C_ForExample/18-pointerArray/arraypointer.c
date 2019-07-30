#include <stdio.h>

int main(){
	int temp[5] = {1,2,3,4,5}; //初始化一个整型数组 
	int (*p1)[5] = &temp;    //需要取temp数组的地址 ,最好加上&取地址运算符 
	int i;
	for(i=0;i<5;i++){
		printf("(*p1)[%d]=%d\n",i,*(*p1+i));
	}
	return 0;
}

