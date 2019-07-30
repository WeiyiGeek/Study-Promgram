#include <stdio.h>

int main()
{
        for ( int i=0,j=10; i <= j; i++,j--){ //可以直接定义变量,但是只能在这个循环中使用.
                printf("%d -- %d\n",i,j);
        }

        return 0;
}
