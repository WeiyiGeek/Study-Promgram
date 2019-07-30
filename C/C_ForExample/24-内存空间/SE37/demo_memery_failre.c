#include <stdio.h>
#include <stdlib.h>
#if 0
int main()
{
    //会导致CPU/memery空间爆满
    while (1) {
      malloc(1024);  //申请并不使用
    }
    return 0;
}
#endif

int main(void)
{
  int *ptr = NULL;
  int *num = 123;
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
  
  ptr = &num;
	printf("输出上面重新赋的值 ：%d\n", *ptr);

  free(ptr); //结束一个局部变量,会导致程序执行异常

  return 0;
}
