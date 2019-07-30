/*在C语言的标准库函数limits.h里面就能通过打印宏判断出当前系统不同类型占用的字节数**/
#include <stdio.h>
#include <limits.h>


int main()
{
  printf("一个字节是 %d 位! \n\n", CHAR_BIT);

  printf("signed char 的最小值是 ：%d\n", SCHAR_MIN);
  printf("signed char 的最大值是 ：%d\n", SCHAR_MAX);
  printf("unsigned char 的最大值是 ：%u\n\n", UCHAR_MAX);

  printf("signed short 的最小值是 ：%d\n", SHRT_MIN);
  printf("signed short 的最大值是 ：%d\n", SHRT_MAX);
  printf("unsigned short 的最大值是 ：%u\n\n", USHRT_MAX);

  printf("signed int 的最小值是 ：%d\n", INT_MIN);
  printf("signed int  的最大值是 ：%d\n", INT_MAX);
  printf("unsigned int 的最大值是 ：%u\n\n", UINT_MAX);

  printf("signed long 的最小值是 ：%ld\n", LONG_MIN);
  printf("signed long 的最大值是 ：%ld\n", LONG_MAX);
  printf("unsigned long 的最大值是 ：%lu\n\n", ULONG_MAX);

  printf("signed long long 的最小值是 ：%lld\n", LLONG_MIN);
  printf("signed long long 的最大值是 ：%lld\n", LLONG_MAX);
  printf("unsigned long long 的最大值是 ：%llu\n\n", ULLONG_MAX);
  return 0;
}
