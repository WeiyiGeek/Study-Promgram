#include <stdio.h>

int max(int x, int y);

int max(int x, int y)
{
  if(x > y)
    return x;  //程序一旦进入return 则下面的程序将不会被执行,它将直接返回
  else
    return y;

}


int main()
{
  int a, b, c;
  printf("请输入两个整数：");
  scanf("%d %d",&a,&b);
  c = max(a,b);
  printf("MAX(a,b) = %d\n",c );
  return 0;
}
