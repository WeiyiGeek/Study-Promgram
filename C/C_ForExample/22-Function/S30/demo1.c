#include <stdio.h>

int square(int num);
int square(int num)
{
  return num * num;
}

int main()
{
  int num;
  int (*fp)(int);  //函数指针
  printf("请输入一个整数:");
  scanf("%d",&num);
  fp = &square;  //对函数取地址
  printf("%d * %d = %d\n",num,num,(*fp)(num));

  return 0;
}
