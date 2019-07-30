#include <stdio.h>
#include <math.h>

int main()
{
        int sign = 1; // 表示符号
        double pi = 0.0, n = 1, term = 1.0; // n表示分母，term表示当前项的值

        while (fabs(term) >= 1e-8) // 1e-8表示10^(-8)
        {
                pi = pi + term;
                n = n + 2;
                sign = -sign;  //进行正负 交替 --=+ 
                term = sign / n;   //为 - 1/3 
        }

        pi = pi * 4;
        printf("pi = %10.7f\n", pi);

        return 0;
}
