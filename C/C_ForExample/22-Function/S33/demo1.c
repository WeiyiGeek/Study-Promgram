#include <stdio.h>

int A; //全局变量 A B C
static int B; //内部链接
extern int C; //外部链接


//文件作用域 属于静态存储期
void func(int m, int n) {
  int a, b, c; //局部变量,代码块作用域,动态存储期
}

int main(void){
  int i, j, k; //局部变量,代码块作用域,动态存储期
  return 0;
}
