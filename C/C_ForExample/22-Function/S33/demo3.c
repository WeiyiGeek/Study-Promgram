#include <stdio.h>

int main(){
  register int i = 520;
  printf("i = %d\n", i);
  printf("i = %p\n", &i); //取地址会报错,去掉register就能成功获取内存地址
  return 0;
}
