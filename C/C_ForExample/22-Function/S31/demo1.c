#include <stdio.h>

int main()
{
  int i = 520;
  printf("before, i = %d\n", i);
  for (int i = 0; i < 10; i++){  //ѭ������֧�ֶ��� -std=c99 �����ʱ��
    printf("%d\n", i);   //forѭ���ڲ�����ı���ֻ��for�ڲ�������
  }
  printf("After,i = %d\n", i);
}
