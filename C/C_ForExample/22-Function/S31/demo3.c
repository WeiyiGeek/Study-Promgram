#include <stdio.h>


int a,b=520;  //a 初始化 默认为0
void func();
void func(){
  int b; //局部变量
  a = 880; //修改全部变量
  b = 120;
  printf("In Func, a = %d, b= %d\n",a,b);
}

int main(){
  printf("In main 1,a = %d, b = %d\n",a,b);
  func();
  printf("In main 2,a = %d, b = %d\n",a,b);
  return 0;
}
