#include <stdio.h>

void swap(int x, int y);

void swap(int x, int y)
{
  int temp;
  printf("Swap »¥»»Ç°£ºx = %d , y = %d\n",x,y);
  temp = x;
  x = y;
  y = temp;
  printf("Swap »¥»»ºó£ºx = %d , y = %d\n",x,y);
}

int main(){
  int x = 1;
  int y = 2;
  printf("Main »¥»»Ç°£ºx = %d , y = %d\n",x,y);
  swap(x,y);
  printf("Main »¥»»ºó£ºx = %d , y = %d\n",x,y);
  return 0;
};
