#include <stdio.h>
#include <math.h>

int main()
{
        long long i, j, k, l, num = 600851475143;
        _Bool flag = 1;

        for (i = 2, j = num/i; flag != 0; i++, j = num/i, flag = 1)
        {
                if (i * j == num) //���ܲ�������,��������������� 
                {		printf("%lld\n",j);
                        k = sqrt((double)j);  //�����������ķ���֮һ.
                        for (l = 2; l <= k; l++)
                        {
                                if ( !(j % l) )
                                {
                                        flag = 0;
                                        break;
                                }
                        }
                        if (flag)
                        {
                                break;
                        }
                        
                }
        }

        printf("%lld\n", j);

        return 0;
}
