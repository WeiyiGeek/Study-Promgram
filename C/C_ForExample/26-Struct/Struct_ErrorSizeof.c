#include <stdio.h>

struct Abc
{
    char a;              //1B
    int b;               // 4B
    char c;              //1B
} abc = {'C', 520, 'I'}; //结构体初始化

//进行调整后
struct Test
{
    char c; //1B
    char a; //1B
    int b;  // 4B
} test = {'X', 'O', 1024};

int main(void)
{
    printf("结构体的空间大小：%d\n", sizeof(abc));                //输出的是12而不是6,这是因为编译器对结构体的成员进行内存对齐后的结果,为了让CPU很快来读取处理数据的一种方式
    printf("调整结构体成员顺序后的空间大小：%d\n", sizeof(test)); //输出的是8B也是6B,由于4B内存对齐
    return 0;
}