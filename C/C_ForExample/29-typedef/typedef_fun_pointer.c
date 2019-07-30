#include <stdio.h>
typedef int (*PTR_TO_FUN)(void);  //函数指针

int fun(void)
{
  return 520+520;
}

int main(void)
{
  PTR_TO_FUN ptr_to_fun = &fun;  //指针指向函数的地址
  printf("返回值 : %d\n", (*ptr_to_fun)()); //注意函数形参处不用填写
  return 0;
}
