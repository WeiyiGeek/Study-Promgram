#include <stdio.h>

void func(void);  //声明

int main()
{
  extern int count;  //声明,先不要急下面有定义
  func();
  count++;
  printf("In Main, count = %d\n", count);
  return 0;
}

int count = 0;
void func(void)
{
  count++;
  printf("In Func, count = %d\n", count);
}
