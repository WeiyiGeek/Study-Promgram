#include <stdio.h>
#include <time.h>

int main(){
	int a=1,b=4;
        while(b--)
        {
                printf("a+b=%d\n",a+b);
                usleep(2000000);
        }
	return 0;
}

