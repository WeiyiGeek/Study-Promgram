#include <stdio.h>

void swap(int *x, int *y);

void swap(int *x, int *y)
{
  int temp;
  printf("Swap 互换前：x = %d , y = %d\n",*x,*y);  //进行节引用
  temp = *x;
  *x = *y;
  *y = temp;
  printf("Swap 互换后：x = %d , y = %d\n",*x,*y);
}

int main(){
  int x = 1;
  int y = 2;
  printf("Main 互换前：x = %d , y = %d\n",x,y);
  swap(&x,&y);   //由于是指针参数,所以对其参数  取地址
  printf("Main 经过 Swap 互换后：x = %d , y = %d\n",x,y);
  return 0;
};
