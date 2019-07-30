#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 5

int main(void)
{
  int i;
  time_t sec;
  printf("Current Second:%ld\n",(unsigned)time(&sec));
  srand((unsigned)time(&sec));
  for (i = 0; i < MAX; i++) {
    printf("%d : %d\n",i,rand() % 100);
  }
  return 0;
}
