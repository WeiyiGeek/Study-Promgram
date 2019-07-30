#include <stdio.h>

typedef int (*PTR_TO_ARRAY)[3];  //数组指针

int main(void)
{
  int array[3] = {1, 2, 3},i;
  PTR_TO_ARRAY ptr_to_array = &array; //利用PTR声明一个变量,其实就是一个指针,并且给他定义数组的指针

  for(i = 0; i < 3; i++)
  {
    printf("%d  ", (*ptr_to_array)[i]);
  }
  putchar('\n');
  return 0;
}
