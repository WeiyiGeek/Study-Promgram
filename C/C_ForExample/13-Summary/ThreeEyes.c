#include <stdio.h>

int main(){
	int i,j,max;
	printf("Please input seconde number:");
	scanf("%d %d",&i,&j);
	
	max = i > j ? i:j;  //为真就将i值赋值给max，否则将j值赋值给max.

	printf("Max=%d\n",max);
	return 0;
}
