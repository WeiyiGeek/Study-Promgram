#include <stdio.h>
typedef int *(*PTR_TO_FUN)(int); //指针函数

//下面这样写是有问题,调用的时候就压栈,退出就弹栈,说白了栈的数据是临时(当函数调用完毕后里面的数据就没有什么意义了)
int *funA(int num)
{
  printf("%d\t", num);
  return &num;  //这里会有警告,返回一个局部变量的地址
}
int *funB(int num)
{
  printf("%d\t", num);
  return &num;
}
int *funC(int num)
{
  printf("%d\t", num);
  return &num;
}
int main(void)
{
    int i;
    PTR_TO_FUN array[3] = {&funA, &funB, &funC}; //函数名就是指向函数的地址
    for(i = 0; i < 3; i++){
      printf("add of num : %p\n",(*array[i])(i)); //*array[i]指针数组取得每个函数的地址,然后返回局部变量num的地址(其实是一样的)
    }
    return 0;
}
