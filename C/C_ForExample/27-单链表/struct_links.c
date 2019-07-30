#include <stdio.h>

int main(void)
{
  #if 0
  //下面这样是不行的,陷入了一个死循环,类似于递归,有去无回
  struct Test
  {
    int x;
    struct Test test;
  };
  #endif
  //如何解决这种困境,万能的指针来了
  struct Test
  {
    int x;
    struct Test *test; //第三方的指针变量,指向Test自身的指针变量（4个直接）
  } test = {1,NULL};
  printf("Sucessful ：%d\n", test.x);
  return 0;
}
