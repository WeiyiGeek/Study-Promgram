#include <stdio.h>

int main()
{
        long int a = 1, b = 1, c, i;

        for (i = 3; i <= 24; i++)
        {
                c = a + b;  //第三年就等于 f(1)+f(2) 
                a = b;  //f(2) 
                b = c;  //f(3) 
        }

        printf("两年后，总共有%ld只兔子！\n", c);

        return 0;
}
