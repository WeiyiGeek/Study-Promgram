#include <stdio.h>

int main()
{
        int i, j, target, invert = 0, num = 998001; // 999 * 999

        for ( ; num > 10000; num--)
        {
                // ��������
                target = num;
                invert = 0;
                while (target)
                {
                        invert = invert * 10 + target % 10;
                        target = target / 10;
                }

                // �����������һ�£�˵�������ǻ�����
                if (invert == num)
                {
                        for (i = 100; i < 1000; i++)
                        {
                                if (!(num % i) && (num / i >= 100) && (num / i < 1000))
                                {
                                        goto FINDIT;
                                }
                        }
                }
        }

FINDIT: printf("�����%d == %d * %d\n", num, i, num / i);

        return 0;
}
