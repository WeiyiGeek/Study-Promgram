#include <stdio.h>

void binary(unsigned long n);

void binary(unsigned long n)
{
        int r;

        r = n % 2;
        if (n >= 2)
        {
                binary(n / 2);
        }

        putchar('0' + r); // '0' + 1 == '1'
}

int main(void)
{
        unsigned long number;

        printf("请输入一个正整数：");
        scanf("%lu", &number);

        binary(number);
        putchar('\n');

        return 0;
}
