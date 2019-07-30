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
                c = a + b;  //斐波那契数列(Fibonacci sequence),又称黄金分割数列、因数学家列昂纳多·斐波那契(Leonardoda Fibonacci)以
                a = b;
                b = c;
        } while (c < 4000000);

        printf("四百万Fibonacci Sequence中偶数之和为:%ld\n", sum);

        return 0;
}