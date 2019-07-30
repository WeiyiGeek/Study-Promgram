#include <stdio.h>
int i; //全局变量

int main(){
  auto int i; //屏蔽同名的全局变量
  return 0;
}
