#include <stdio.h>

int main()
{
        int array[5] = {1, 2, 3, 4, 5};
        int *pi = &array[2];
        void *pv;

        pv = pi;
        printf("%p, %p\n", pv, pi);

        pv++;
        pi = pv;
        printf("%p, %p\n", pv, pi);

        printf("%d\n", *pi);

        return 0;
}
