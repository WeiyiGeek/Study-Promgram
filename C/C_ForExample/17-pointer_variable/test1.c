#include <stdio.h>
#include <string.h>

int main()
{
        char str[] = "I love FishC.com!";

        str[7] = '\0';

        printf("sizeof str = %d\n", sizeof(str));
        printf("strlen str = %d\n", strlen(str));

        return 0;
}
