#include <stdio.h>

int main()
{
        long count1 = 0, count2; // count���ڴ��һ�����˶�����
        int year1, year2, year3; // year1�����������ݣ�year2�ǽ�������
        int month1, month2, month3;
        int day1, day2, day3;
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        printf("������������գ���1988-05-20����");
        scanf("%d-%d-%d", &year1, &month1, &day1);

        printf("�������������ڣ���2016-03-28����");
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
                                        printf("��������������ܹ�������%d��\n", count2);
                                }

                                if (year1 == year3 && month1 == month3 && day1 == day3)
                                {
                                        printf("����ܻ80�꣬�㻹ʣ��%d��\n", count1 - count2);
                                        printf("���Ѿ�ʹ����%.2f\%����������ú���ϧʣ�µ�ʱ�䣡\n", (double)count2 / count1 * 100);
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
