#include <stdio.h>

int main()
{
        long a = 1, b = 2, c, sum = 0;

        do
        {
                if (!(b % 2))
                {
                        sum += b;
                }
                c = a + b;  //쳲���������(Fibonacci sequence),�ֳƻƽ�ָ����С�����ѧ���а��ɶࡤ쳲�����(Leonardoda Fibonacci)��
                a = b;
                b = c;
        } while (c < 4000000);

        printf("�İ���Fibonacci Sequence��ż��֮��Ϊ:%ld\n", sum);

        return 0;
}