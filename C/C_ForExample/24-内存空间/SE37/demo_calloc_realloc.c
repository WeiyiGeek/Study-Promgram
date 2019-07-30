#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int *ptr = NULL;  //注意对于使用 realloc 函数 这里的 ptr 需要初始化为NULL （必须的）
  //int *num = 123;
 // ptr = (int *)realloc(ptr,1 * sizeof(int));  //这里采用重新分配内存空间函数
    ptr = (int *)calloc(1,sizeof(int));
  if( ptr == NULL)
  {
    printf("分配内存失败！\n");
    exit(1);
  }
  printf("初始化的值 ：%d\n", *ptr);
  printf("请输入一个数 ：");
  scanf("%d",ptr);

  printf("输出上面的值 ：%d\n", *ptr);
  
  //ptr = &num;
  //printf("输出上面重新赋的值 ：%d\n", *ptr);

  free(ptr); //结束一个局部变量,会导致程序执行异常
  return 0;
}
