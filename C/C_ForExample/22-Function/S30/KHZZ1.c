#include <stdio.h>
#include <stdlib.h>

#define  EPSINON 0.0000001  //控制精度

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
  if(y >= -EPSINON && y <= EPSINON)   //使除数不为0
  {
    printf("除数不能为0\n");
    exit(EXIT_FAILURE);
  }else{
    return x / y;
  }
}


int main(void)
{
  double x, y;
  double (*funp[4])(double x,double y) = {add,sub,mul,divi};
  printf("请输入两个数字例如(12 13):");
  scanf("%lf %lf",&x,&y);  // 注意这里double 是长整型 ，float才是%f 
  printf("对这两个数进行加减乘除为：");
  for (int i = 0; i < 4; i++) {
    printf("%.2f\t", (*funp[i])(x,y));
  }
  return 0;
}
