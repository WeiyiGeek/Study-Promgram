#include <stdio.h>

#define MAX(x, y) ((x) > (y)) ? (x) : (y)

int main(void)
{   
    int x,y;
    printf("请输入两个整数：");
    scanf("%d %d", &x, &y);
    printf("%d 是最大的那一个数 !! \n", MAX(x,y));
    return 0;
}