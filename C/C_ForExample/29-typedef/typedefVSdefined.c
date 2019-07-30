#include <stdio.h>
/**对比typedef 与 define的异同 对于输出负数的时候**/

#if 0
#define INTEGER int
int main(void)
{
  unsigned INTEGER a;
  a = -1;
  printf("define方法，以十进制无符号类型输出 ：%u\n", a);
  return 0;
}
#endif

//如果使用typedef方法是会报错的
#if 1
typedef int integer;
int main(void)
{
  unsigned integer a;
  a = -1;
  printf("以十进制无符号类型输出 ：%u\n", a);
  return 0;
}
#endif
