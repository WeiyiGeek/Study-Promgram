#include <stdio.h>
#include <math.h>

int main()
{
        int sign = 1; // ��ʾ����
        double pi = 0.0, n = 1, term = 1.0; // n��ʾ��ĸ��term��ʾ��ǰ���ֵ

        while (fabs(term) >= 1e-8) // 1e-8��ʾ10^(-8)
        {
                pi = pi + term;
                n = n + 2;
                sign = -sign;  //�������� ���� --=+ 
                term = sign / n;   //Ϊ - 1/3 
        }

        pi = pi * 4;
        printf("pi = %10.7f\n", pi);

        return 0;
}
