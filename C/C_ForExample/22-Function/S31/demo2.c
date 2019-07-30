#include <stdio.h>

void a();
void b();
void c();

int count = 0; //全局变量,函数外部定义

void a(){
  count++;
}
void b(){
  count++;
}

void c(){
  count++;
}

int main()
{
  a(); //调用四次
  b();
  c();
  b();
  printf("Result:%d\n",count);
  return 0;
}
