#include <stdio.h>

int func1(void);
int func2(void);

int func1(void)
{
        int a = 520;

        printf("a is %d, add of a is %p\n", a, &a);
}

int func2(void)
{
        int b = 880;

        printf("b is %d, add of b is %p\n", b, &b);
}

int main(void)
{
        func1();
        func2();

        return 0;
}
