#include <stdio.h>

void func();

void func()
{
  extern int count;  //最好在extern 后面加上 变量类型和变量名
  count++;
}

int count = 0;
int main()
{
  func();
  printf("%d\n", count);
  return 0;
}
