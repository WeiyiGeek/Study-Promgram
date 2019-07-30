#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NUM 10

int main(void)
{
        int *ptr;
        ptr = (int *)malloc(NUM * sizeof(int));
        if (ptr == NULL)
        {
                exit(1);
        }
        memset(ptr, 0, NUM);  //用0填充ptr指向的地址

        printf("ptr Address : %p \tValue : %d\n",ptr,*ptr);
        return 0;
}
