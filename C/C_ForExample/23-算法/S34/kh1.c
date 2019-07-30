#include <stdio.h>
unsigned int fibonacci(unsigned int n);
unsigned int fibonacci(unsigned int n)
{
    if (n == 1 || n == 2)
    {
        return 1; //精妙之处
    }
    else
    {
        return fibonacci(n - 1) + fibonacci(n - 2); //从 n = 3 开始进行计算
    }
}

int main(void)
{
    unsigned int number, i;
    int count;
    printf("请输入一个整数：");
    scanf("%u", &number);
    printf("斐波那契数列前%u个的数为：", number);
    for (i = 1; i <= number; i++)
    {
        printf("%lu ", fibonacci(i));
    }
    putchar('\n');
    return 0;
}