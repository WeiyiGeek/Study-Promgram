#include <stdio.h>
#include <time.h>

int main(){
	int a=1,b=4;
	while(b--)
	{
		printf("a+b=%d\n",a+b);
		sleep(5);
	}
	return 0;
}
