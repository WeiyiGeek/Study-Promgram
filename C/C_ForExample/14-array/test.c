#include <stdio.h>

int main()
{
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int i, year;

        printf("请输入一个年份：");
        scanf("%d", &year);

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
        {
                days[1] = 29;
        }

        for (i = 0; i < sizeof(days) / sizeof(days[0]); i++) //
        {
                printf("%d --- %d \n",sizeof(days),sizeof(days[0]));
        }
        return 0;
}
