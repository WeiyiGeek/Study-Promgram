#include <stdio.h>

#define EARTHR 6371  //地球的半径
#define PI 3.14
#define EARTHV PI * EARTHR * EARTHR * EARTHR * 4 / 3   //宏定义的嵌套使用 

int main(void)
{
#undef EARTHR
    printf("地球的半径为%d,它的面积是：%.2f\n",EARTHR,EARTHV);
    return 0;
}