#include <stdio.h>
#include <string.h>
//声明结构体
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
  //进行union中成员赋值
  test.i = 520;
  test.j = 1024;
  test.pi = 3.1415926;
  strcpy(test.name,"C-union");
  printf(" |===== UNION 成员地址打印(其实地址都相同)=====|\n");
  printf(" address of test.i = %p\n",&test.i);
  printf(" address of test.j = %p\n",&test.j);
  printf(" address of test.pi = %p\n",&test.pi);
  printf(" address of test.name = %p\n\n",&test.name);

  printf(" |===== UNION 成员值打印(只有test.name输出正确) =====|\n");
  printf(" value of test.i = %d\n",test.i);
  printf(" value of test.j = %.2f\n",test.j);
  printf(" value of test.pi = %.2f\n",test.pi);
  printf(" value of test.name = %s\n\n",test.name);

  printf(" |===== UNION 共同体空间大小验证(有内存对齐所以不是10B)  =====|\n");
  printf("sizeof(union Date) = %dB\n", sizeof(union Date));

  return 0;
}
