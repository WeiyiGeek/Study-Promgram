#include <stdio.h>
#define INTEGER int  //注意这不是个语句

typedef int integer;  //Method ： 1
int main(void)
{
  int a;
  integer b;
  INTEGER c;
  a = 520;
  b = a;
  c = b;
  printf("采用typedef关键字来声明别名：\n");
  printf("a = %d, b = %d\n", a, b);
  printf("sizeof(a) = %d, sizeof(b) = %d\n\n", sizeof(a), sizeof(b));

  printf("采用#define来声明一个常量替换功能：\n");
  printf("b = %d, c = %d\n", b, c);
  printf("sizeof(b) = %d, sizeof(c) = %d\n\n", sizeof(b), sizeof(c));

  return 0;
}
