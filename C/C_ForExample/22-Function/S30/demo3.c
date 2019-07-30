#include <stdio.h>

int add(int, int);
int sub(int, int);
int calc(int (*fp)(int, int), int, int);
int (*select(char op))(int, int);  //优先级从左到右

int add(int num1, int num2)
{
  return num1 + num2;
}

int sub(int num1, int num2)
{
  return num1 - num2;
}

int calc(int (*fp)(int,int), int num1, int num2)
{
  return (*fp)(num1, num2);
}

int (*select(char op))(int, int)
{
  switch (op) {
    case '+':return add;
    case '-':return sub;
    default: return 0;
  }
}

int main()
{
  int num1,num2;
  char op;
  int (*fp)(int,int);
  printf("请输入一个式子（3+1）：");
  scanf("%d %c %d",&num1,&op,&num2);
  fp = select(op);
  printf("%d %c %d = %d\n", num1, op, num2,calc(fp, num1, num2));
  return 0;
}
