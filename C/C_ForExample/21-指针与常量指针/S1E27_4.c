#include <stdio.h>

int main()
{
        const int num = 520;
       	int *p = &num;

        printf("num = %d\n", num);

        p = 1024;
        printf("num = %d\n", num);

        return 0;
}
