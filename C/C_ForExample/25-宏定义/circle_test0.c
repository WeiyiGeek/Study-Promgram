#include <stdio.h>
#define PI 3.1415926

int main(void)
{
    int r;
    float s;
    printf("请输入圆的半径 :");
    scanf("%d",&r);
    s = PI * r * r;
    printf("圆的面积为 ：%.2f\n",s);

    return 0;
}