#include  <stdio.h>

void func(void);

void func(void){
  static int count = 0;  //static 声明局部变量,count变成了静态存储期,则在程序结束后释放内存空间
  printf("count = %d\n", count);
  count++;
}

int main(void)
{
  for(int i; i < 10; i++){
    func();
  }
  return 0;
}
