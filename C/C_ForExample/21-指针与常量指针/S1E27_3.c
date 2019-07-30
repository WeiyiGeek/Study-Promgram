#include <stdio.h>

int main()
{
        int num = 520;
        void *p;

	p = &num;

        printf("%d\n",*(int *)p);

        return 0;
}
