#include <stdio.h>

int main()
{
        char str[] = "中";  //Linux占用3个字节   //windows占用2个字节
        int length, i;

        length = sizeof(str) / sizeof(str[0]);  //求处长度

        printf("length of str: %d\n", length);
        for (i = 0; i < length; i++){
                printf("str[%d] = %d\n", i, str[i]);
        }

        return 0;
}
