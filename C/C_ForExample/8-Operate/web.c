#include <stdio.h>

int main(){
	
	int Tarray[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};  //10个坑位 array[0] ~ array[9]
	
	int *p = Tarray;
	int *pt = (int *)&Tarray;
	
	//int *pt10 = (int *)(&Tarray+1);

	int (*pta)[10] = &Tarray;    //指向整体 
	printf("&Tarray[0]:%p,	%p,	%p,	%p",&Tarray[0],p,pt,*pta); //数组的首地址 
	
	int *pt10 = (int *)(&Tarray+1); //指向a[10] 地址就是第11个元素 ， 注意不能放在9line前面由于后面会恢复指向首地址 
	printf("\n&Tarray[10]:%p,	*pt10:%p,	 *(*(pta+1)):%p\n",&Tarray[10],pt10,*(*(pta+1)));  //数组的尾地址加1的地址 
	
		
	return 0;
}

