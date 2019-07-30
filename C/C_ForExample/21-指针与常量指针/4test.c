#include <stdio.h>

int main(){
	int num = 520;

	const int cnum = 1024;
	const int * const p = &num;
	const int * const *pp = &p;

	printf("pp: %p, &p: %p\n",pp,&p);
	printf("*pp: %p, p: %p, &num: %p\n",*pp,p,&num); //注意解引用与取值的对应平等关系

	printf("**pp: %d, *p: %d\n",**pp,*p);
	
	return 0;	
}
