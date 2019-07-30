#include <stdio.h>

int main()
{
  int i = 520;
  printf("before, i = %d\n", i);
  for (int i = 0; i < 10; i++){  //循环里面支持定义 -std=c99 编译的时候
    printf("%d\n", i);   //for循环内部定义的变量只在for内部起作用
  }
  printf("After,i = %d\n", i);
}
