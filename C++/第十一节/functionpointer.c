#include <stdio.h>

int fun(int x, int y);
int main()
{
        int (*p)();    /* ��������ָ�� */
        p = fun;            /* ������ָ��p��ֵ,ʹ��ָ����f */
        printf("The Max Number is:%d", (*p)(5, 6));   /* ͨ��ָ��p���ú���f */
        return 0;
}

fun(int x, int y)
{
    int z = (x > y) ? x : y;
    return(z);
}
