#include <stdio.h>

int main(){
	int a;
	int *p = &a;
	printf("Please input int:");
	scanf("%d",&a);
	printf("a= %d \n",a);
	
	printf("Please again input int:");
	scanf("%d",p);
	printf("a = %d \n",a);

	return 0;

}
