#include <stdio.h>

void get_array(int b[10]);

void get_array(int b[10])
{
  printf("get_array sizeof b: %d\n",sizeof(b));  //由于传入实际是地址占用4B 
}

int main(){
  int a[10] = {0};
  printf("main sizeof a: %d\n", sizeof(a));  //由于是整型占4Bx10 = 40B 
	get_array(a);
  return 0;
}
