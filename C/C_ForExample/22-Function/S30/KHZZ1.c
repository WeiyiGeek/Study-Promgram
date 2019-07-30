#include <stdio.h>
#include <stdlib.h>

#define  EPSINON 0.0000001  //���ƾ���

double add(double x,double y);
double sub(double x,double y);
double mul(double x,double y);
double divi(double x,double y);

double add(double x,double y)
{
  return x + y;
}

double sub(double x,double y)
{
  return x - y;
}

double mul(double x,double y)
{
  return x * y;
}

double divi(double x,double y)
{
  if(y >= -EPSINON && y <= EPSINON)   //ʹ������Ϊ0
  {
    printf("��������Ϊ0\n");
    exit(EXIT_FAILURE);
  }else{
    return x / y;
  }
}


int main(void)
{
  double x, y;
  double (*funp[4])(double x,double y) = {add,sub,mul,divi};
  printf("������������������(12 13):");
  scanf("%lf %lf",&x,&y);  // ע������double �ǳ����� ��float����%f 
  printf("�������������мӼ��˳�Ϊ��");
  for (int i = 0; i < 4; i++) {
    printf("%.2f\t", (*funp[i])(x,y));
  }
  return 0;
}
