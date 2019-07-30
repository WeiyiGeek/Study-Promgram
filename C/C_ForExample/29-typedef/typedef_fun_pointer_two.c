#include <stdio.h>
typedef int (*FUN_TO_PTR)(int, int); //函数指针的别名

int add(int, int);
int sub(int, int);
//int calc(int (*fp)(int, int), int, int); //“函数指针第一个参数”
int calc(FUN_TO_PTR,int,int);

//int (*select(char op))();  //优先级从左到右 (函数指针可以无参数类型)
FUN_TO_PTR select(char);

int add(int num1, int num2)
{
  return num1 + num2;
}

int sub(int num1, int num2)
{
  return num1 - num2;
}

int calc(int (*fp)(int, int), int num1, int num2)
{
  return (*fp)(num1, num2);
}

FUN_TO_PTR select(char op)  //针对于运算符号
{
  switch (op) {
    case '+':return &add;  //返回函数名地址 == 函数名
    case '-':return sub;
    default: return 0;
  }
}

int main()
{
  int num1,num2;
  char op;
  int (*fp)(int,int); //函数指针 （存放函数的指针）
  printf("请输入一个式子（3+1）：");
  scanf("%d %c %d",&num1,&op,&num2);

  fp = select(op);  //利用运算操作表达式函数 选择 运算符号对应的函数名

  printf("%d %c %d = %d\n", num1, op, num2,calc(fp, num1, num2)); //fp 传入函数名
  return 0;
}
