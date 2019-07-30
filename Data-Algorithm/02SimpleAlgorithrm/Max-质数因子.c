#include <stdio.h>
#include <math.h>

int main()
{
        long long i, j, k, l, num = 600851475143;
        _Bool flag = 1;

        for (i = 2, j = num/i; flag != 0; i++, j = num/i, flag = 1)
        {
                if (i * j == num)            //看能不能整除,首先求得最大的素数  (不一定能被整除)
                {
                        printf("%lld ==>>  %lld\n", i ,j);
                        k = sqrt((double)j);  //求素数的最快的方法之一.

                        for (l = 2; l <= k; l++)
                        {
                                if ( !(j % l) )  //判断在根号里面的数是否能被整除 (是则执行 跳出)
                                {
                                        flag = 0;
                                        break;
                                }
                        }
                        if (flag)  //最后一个是质数 所以这里是flag = 1; 然后退出循环
                        {
                                break;
                        }

                }
        }
        printf("最大质数因子：%lld\n", j);

    return 0;
}
