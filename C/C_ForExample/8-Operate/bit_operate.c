#include <stdio.h>
//注意逻辑位运算符只支持整型数据

int main(void)
{
  int mask = 0XFF; // 1111 1111
  int v1 = 0XABCDEF; //1010 1011 1100 1101 1110 1111
  int v2 = 0XABCDEF;
  int v3 = 0XABCDEF;

  v1 &= mask;
  v2 ^= mask;
  v3 |= mask;

  printf("v1 = 0x%X\n", v1);
  printf("v2 = 0x%X\n", v2);
  printf("v3 = 0x%X\n", v3);
  printf("mask= 0x%X\n", ~mask);
  return 0;
}
