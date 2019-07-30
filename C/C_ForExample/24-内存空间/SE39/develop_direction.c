#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int *ptr1 = NULL;
  int *ptr2 = NULL;

  ptr1 = (int *)malloc(sizeof(int));
  ptr2 = (int *)malloc(sizeof(int));

  printf("stack (栈)：%p -> %p\n", &ptr1, &ptr2);  //内存地址从高到低
  printf(" heap (堆)：%p -> %p\n", ptr1, ptr2);  //申请完成后是存放在ptr1/2两个指针里面的,所以直接打印值 （内存地址从低到高）

  ptr1 = (int *)realloc(ptr1 , 3 * sizeof(int));  //由于申请的空间(16B - 4B - 3 * 4B)刚好够用所以上面的地址不变
  printf("heap (堆不变)：%p -> %p\n", ptr1, ptr2);

  ptr1 = (int *)realloc(ptr1 , 4 * sizeof(int));  //这里会重新分配内存空间,ptr1地址将会发生改变
  ptr2 = (int *)realloc(ptr2 , 4 * sizeof(int));  //这里会重新分配内存空间,ptr2地址将会发生改变
  printf("heap (堆改变)：%p -> %p\n", ptr1, ptr2);

  return 0;
}
