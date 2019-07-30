#include <stdio.h>
#define BUFSIZE 3

int main(void)
{
        char buf[BUFSIZE];
      	//为输出存入一个缓存区
	setbuf(stdin, buf);
        fprintf(stdout,"Hello, world! wwwww \n");
	setbuf(stdout, buf);
	sleep(5);
        return 0;
}
