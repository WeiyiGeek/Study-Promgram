#include <stdio.h>

int main()
{
        long count1 = 0, count2; // count用于存放一共活了多少天
        int year1, year2, year3; // year1是你的生日年份，year2是今天的年份
        int month1, month2, month3;
        int day1, day2, day3;
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        printf("请输入你的生日（如1988-05-20）：");
        scanf("%d-%d-%d", &year1, &month1, &day1);

        printf("请输入今天的日期（如2016-03-28）：");
        scanf("%d-%d-%d", &year2, &month2, &day2);

        year3 = year1 + 80;
        month3 = month1;
        day3 = day1;

        while (1)
        {
                days[1] = (year1 % 400 == 0 || (year1 % 4 == 0 && year1 % 100 != 0)) ? 29 : 28;
                while (month1 <= 12)
                {
                        while (day1 <= days[month1 - 1])
                        {
                                if (year1 == year2 && month1 == month2 && day1 == day2)
                                {
                                        count2 = count1;
                                        printf("你在这个世界上总共生存了%d天\n", count2);
                                }

                                if (year1 == year3 && month1 == month3 && day1 == day3)
                                {
                                        printf("如果能活到80岁，你还剩下%d天\n", count1 - count2);
                                        printf("你已经使用了%.2f\%的生命，请好好珍惜剩下的时间！\n", (double)count2 / count1 * 100);
                                        goto FINISH;
                                }

                                day1++;
                                count1++;
                        }
                        day1 = 0;
                        month1++;
                }
                month1 = 0;
                year1++;
        }

FINISH: return 0;
}
