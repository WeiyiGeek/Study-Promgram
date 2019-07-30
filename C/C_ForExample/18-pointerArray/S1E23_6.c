#include <stdio.h>

int main()
{
        int array[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int (*p)[10] = &array;

        printf("%d\n",*(*(p+1)-6)); //array[11-6] = array[5];

        return 0;
}
