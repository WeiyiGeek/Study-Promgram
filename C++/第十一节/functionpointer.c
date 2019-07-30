#include <stdio.h>

int fun(int x, int y);
int main()
{
        int (*p)();    /* 声明函数指针 */
        p = fun;            /* 给函数指针p赋值,使它指向函数f */
        printf("The Max Number is:%d", (*p)(5, 6));   /* 通过指针p调用函数f */
        return 0;
}

fun(int x, int y)
{
    int z = (x > y) ? x : y;
    return(z);
}
