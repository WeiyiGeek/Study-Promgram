#include <stdio.h>

int main(){
	unsigned int year;
	printf("Plase Input years:");
	scanf("%d",&year);
	if ((year%4==0 && year%100!=0)||(year%400==0)){
		printf("%d 年是闰年\n",year);
	}else{
		printf("%d 年不是闰年\n",year);
	}
	return 0;
}
