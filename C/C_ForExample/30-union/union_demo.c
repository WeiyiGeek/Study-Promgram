#include <stdio.h>
#include <string.h>
//�����ṹ��
union Date
{
  int i;
  float j;
  double pi;
  char name[10];
};

int main(void)
{
  union Date test;
  //����union�г�Ա��ֵ
  test.i = 520;
  test.j = 1024;
  test.pi = 3.1415926;
  strcpy(test.name,"C-union");
  printf(" |===== UNION ��Ա��ַ��ӡ(��ʵ��ַ����ͬ)=====|\n");
  printf(" address of test.i = %p\n",&test.i);
  printf(" address of test.j = %p\n",&test.j);
  printf(" address of test.pi = %p\n",&test.pi);
  printf(" address of test.name = %p\n\n",&test.name);

  printf(" |===== UNION ��Աֵ��ӡ(ֻ��test.name�����ȷ) =====|\n");
  printf(" value of test.i = %d\n",test.i);
  printf(" value of test.j = %.2f\n",test.j);
  printf(" value of test.pi = %.2f\n",test.pi);
  printf(" value of test.name = %s\n\n",test.name);

  printf(" |===== UNION ��ͬ��ռ��С��֤(���ڴ�������Բ���10B)  =====|\n");
  printf("sizeof(union Date) = %dB\n", sizeof(union Date));

  return 0;
}
