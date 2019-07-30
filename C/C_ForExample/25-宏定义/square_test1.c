#include <stdio.h>
//#define SQUARE(x) x * x //导致下面的运算结果
#define SQUARE(x) ((x) * (x)) //输出正确值的效果

int main(void)
{
    int x;
    printf("请输入一个数来获取它的平方：");
    scanf("%d", &x);
    printf("%d 的平方为 %d \n", x, SQUARE(x));
    //输出的是 11 这是由于替换机制 与 运算符的优先级导致 , 实际是 x + 1 * x + 1 == 11 (x = 5)
    printf("%d 的平方为 %d \n", x + 1, SQUARE(x + 1)); 
    return 0;
}
