#include <stdio.h>
/**以指针来判断typedef 与 define的不同**/

#if 1
#define INTEGER int
#define PTRINT int*
//也能正常打印
//Warning会打印出这里试图将一个指针变量存放一个整型变量里面去
#endif

typedef int integer;
typedef int *ptrint; //指针

int main(void)
{
  INTEGER a = 520;
  PTRINT b, c;
  //integer a = 520;
  //ptrint b, c;
  b = &a; //指针变量存放a的地址
  c = b;  //指针变量存放a的地址
  printf("address of a, b, c ： %p  %p  %p\n", c, b, &a);

  return 0;
}
