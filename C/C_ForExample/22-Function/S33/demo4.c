#include  <stdio.h>

void func(void);

void func(void){
  static int count = 0;  //static �����ֲ�����,count����˾�̬�洢��,���ڳ���������ͷ��ڴ�ռ�
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
