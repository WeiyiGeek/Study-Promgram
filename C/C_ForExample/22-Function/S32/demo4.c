#include <stdio.h>

void strlenFunc(void);

static char test[] = "static-internal";
int main(void)
{
  printf("In Main , %s\n", test);
  strlenFunc();
  return 0;
}
