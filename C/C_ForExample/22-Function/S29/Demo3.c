#include <stdio.h>

void get_array(int b[10]);

void get_array(int b[10])
{
  printf("get_array sizeof b: %d\n",sizeof(b));  //���ڴ���ʵ���ǵ�ַռ��4B 
}

int main(){
  int a[10] = {0};
  printf("main sizeof a: %d\n", sizeof(a));  //����������ռ4Bx10 = 40B 
	get_array(a);
  return 0;
}
