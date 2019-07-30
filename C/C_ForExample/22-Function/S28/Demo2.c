#include <stdio.h>

int sum(int n);

int main(){
  int n;
  printf("请输入N的值:");
  scanf("%d",&n);
  printf("1+2+3+4+...n=%d\n",sum(n));
  return 0;
}

int sum(int n)
{
  int result = 0;
  do
  {
    result += n;
  }while(n-- > 0);

	return result;
}
