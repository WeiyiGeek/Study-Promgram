#include <stdio.h>

int main(){
	int i,j,max;
	printf("Please input seconde number:");
	scanf("%d %d",&i,&j);
	
	max = i > j ? i:j;  //Ϊ��ͽ�iֵ��ֵ��max������jֵ��ֵ��max.

	printf("Max=%d\n",max);
	return 0;
}
