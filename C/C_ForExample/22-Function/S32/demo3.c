#include <stdio.h>

void a(void);
void b(void);
void c(void);

int count;  //定义

int main()
{
  a(); //调用
  b();
  c();
  b();

  printf("count = %d\n", count);
  return 0;
}
