#include <stdio.h>

void get_array(int a[10]);
void get_againarry(int b[10]);


void get_array(int a[10])
{
  int i;
  printf("在get_array函数里面边打印一次\n");
  for(i = 0; i < 10 ; i++){
    printf("a[%d] = %d \n",i,a[i]);
  }
}


void get_againarray(int b[10])
{
  int i;
  b[5] = 520;
  printf("在get_againarray函数里面边打印一次\n");
  for(i = 0; i < 10 ; i++){
    printf("b[%d] = %d \n",i,b[i]);
  }
}


int main(){
  int a[10] = {1,2,3,4,5,6,7,8,9,0};
  int i;
  get_array(a); 
  get_againarray(a);
  printf("经过get_againarray在main函数里面边再打印一次.....\n");
  for(i = 0; i < 10 ; i++){
    printf("a[%d] = %d \n",i,a[i]);
  }
  return 0;
}
