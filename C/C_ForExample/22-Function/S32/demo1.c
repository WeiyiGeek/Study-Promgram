#include <stdio.h>

int main(void) //如果没有参数就填入void - C99标准
{
  int i = 100; // i1
  //{ } 代码块 , 嵌套内部变量会覆盖外部变量，而且是自上而下的执行
  {
    int i = 110; // i2
    {
        int i = 120; // i3
        printf("i3 = %d\n", i);
    }
    //i = 110 出了上面的代码块
    {
        printf("i2 = %d\n", i);
        int i = 130; // i4
        printf("i4 = %d\n", i);
    }
    printf("i2 = %d\n", i);
  }
  printf("i1 = %d\n", i);
  return 0;
}
