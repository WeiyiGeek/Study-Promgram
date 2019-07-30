#include <stdio.h>

int global_uninit_var;  //未初始化的全局变量 , 在bss段里
int global_init_var = 520;  //初始化的全局变量 , 在data里  (数据段里)

int main(void)
{
  static int local_uninit_var; //为初始化的静态局部变量 , 在bss段里
  static int local_unit_var = 1024; //初始化的静态局部变量, 在data里 (数据段里)
  char *str = "这是在代码段里 text";
//  char str1[30] = "这是在代码段里 text";

  return 0;
}
