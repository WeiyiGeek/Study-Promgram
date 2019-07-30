#include <stdio.h>

int main()
{
        int array[9] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int (*p)[3] = (int (*)[3])&array;

        printf("%d\n", p[2][2]);

        return 0;
}
