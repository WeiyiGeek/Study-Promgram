#include <stdio.h>
#include <stdlib.h>

void *ptrfun(void);  //函数中申请内存空间
void *ptrfun(void)
{
  int *ptr = (int *)calloc(1, sizeof(int)); //申请并初始化内存空间
  if( ptr == NULL )
  {
    printf("申请内存空间失败\n");
    exit(1);
  }
  printf("初始化的值为 : %d\n",*ptr);
  *ptr = 520;  //对申请的空间进行赋值
  return ptr;  //返回堆的地址
}

int main(void)
{
  int *point = NULL;
  point = ptrfun();  //调用申请的内存空间
  printf("从不同函数中调用堆的内存空间 ：%d\n",*point);
  free(point);  //释放内存
  return 0;
}
