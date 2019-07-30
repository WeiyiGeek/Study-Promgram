#include <stdio.h>
#include <stdlib.h>

int global_uninit_var; //全局变量(未初始化)
int global_init_var1 = 520;     //(初始化)
int global_init_var2 = 1024;    //(初始化)

void func(void);  //函数声明
void func(void)
{
  ;
}

int main(void)
{
  int local_var1;  //局部变量 (未初始化)
  int local_var2;  //局部变量 (未初始化)

  static int static_uninit_var;  //静态局部变量(未初始化)
  static int static_init_var = 456;          //初始化

  char *str1 = "Change the world,";  //字符串
  char *str2 = "You are right!";  //字符串

  int *ptr = (int *)malloc(sizeof(int));

  printf("                      func 函数地址 ：%p\n", func); //函数不用取地址
  printf("                    str1 字符串地址 ：%p\n", str1); //字符串数组不用取地址
  printf("                    str2 字符串地址 ：%p\n", str2);
  printf("global_init_var1 全局变量(初始化) : %p\n", &global_init_var1);
  printf("global_init_var2 全局变量(初始化) : %p\n", &global_init_var2);
  printf("static_init_var 局部静态变量(初始化) : %p\n", &static_init_var);
  printf("static_uninit_var 局部静太变量(未初始化) : %p\n", &static_uninit_var);
  printf("global_uninit_var 全局变量(未初始化) ：%p\n", &global_uninit_var);  //特别注意
  printf(" malloc_ptr 动态申请内存空间 ：%p\n", ptr);  //申请的内存控制不用取地址
  printf(" local_var2 局部变量 (未初始化) ：%p\n", &local_var2);  //初始化与位初始化的局部变量 不影响地址var1 小于 var2
  printf(" local_var1 局部变量 (未初始化) ：%p\n", &local_var1);

  return 0;
}
