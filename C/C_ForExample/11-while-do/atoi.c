#include <stdio.h>
#include <stdlib.h>

int main()
{
        printf("%d\n", atoi("FishC123"));
        printf("%d\n", atoi("123FishC"));
        printf("%d\n", atoi("   123  "));
        printf("%d\n", atoi("-123.45 "));
        printf("%d\n", atoi("123456789999999999"));

        return 0;
}
