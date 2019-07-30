#include <stdio.h>

int main(void)
{
  struct Param
  {
    int x;
    int y;
  } t1, t2;  //两个结构体变量

  t1.x = 3; //对结构体变量t1赋值
  t1.y = 6;

  t2 = t1; //将结构体 t1 传递给 t2
  printf("t2.x = %d, t2.y = %d \n", t2.x, t2.y);
  return 0;
}
