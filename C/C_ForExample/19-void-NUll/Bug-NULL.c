#include <stdio.h>

int main(){
	int *p1;
	int *p2 = NULL;
	
	printf("p1hex:%p\n",p1);
		printf("p1dec:%d\n",p1);

	printf("p2hex:%p\n",p2);
		printf("p2dec:%d\n",*p2);

	printf("&p1:%p\n",&p1);
	printf("&p2:%p\n",&p2);
	
	
	return 0;
	
}

