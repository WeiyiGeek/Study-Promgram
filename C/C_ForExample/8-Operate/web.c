#include <stdio.h>

int main(){
	
	int Tarray[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};  //10����λ array[0] ~ array[9]
	
	int *p = Tarray;
	int *pt = (int *)&Tarray;
	
	//int *pt10 = (int *)(&Tarray+1);

	int (*pta)[10] = &Tarray;    //ָ������ 
	printf("&Tarray[0]:%p,	%p,	%p,	%p",&Tarray[0],p,pt,*pta); //������׵�ַ 
	
	int *pt10 = (int *)(&Tarray+1); //ָ��a[10] ��ַ���ǵ�11��Ԫ�� �� ע�ⲻ�ܷ���9lineǰ�����ں����ָ�ָ���׵�ַ 
	printf("\n&Tarray[10]:%p,	*pt10:%p,	 *(*(pta+1)):%p\n",&Tarray[10],pt10,*(*(pta+1)));  //�����β��ַ��1�ĵ�ַ 
	
		
	return 0;
}

