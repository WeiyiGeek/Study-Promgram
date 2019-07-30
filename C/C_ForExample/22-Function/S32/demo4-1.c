#include <stdio.h>
#include <string.h>

extern char test[];

void strlenFunc(void)
{
  printf("In strlenFunc = %d\n", strlen(test));
}
