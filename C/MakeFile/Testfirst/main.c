#include <stdio.h>
#include "visit.h"
#include "study.h"
main(){
	int i;
	printf("Please input the value of i from 1 to 5:\n");
	scanf("%d",&i);
	if(i==1)
		visit();
	if(i==2)
		study();
}
