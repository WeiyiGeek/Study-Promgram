#include <stdio.h>
#define SQUARE(x) ((x) * (x))

//使用内联函数
inline int square(int x);
inline int square(int x)
{
    printf("%d 的平方是 : %d\n", x, x * x);
}

int main(void)
{
    int x;
    printf("采用了内联函数:\n");
    while(x < 10) {
        square(x++);  //先赋值在+1
    }
    printf("采用了宏定义(有BUG的):\n");
    x = 0;
    while (x < 10)
    {
        //当注意当宏定义形参为x++时候会出现错误, x=0; ((x++) * (x++))  ==>> ( 0 * 1) ,  x=2; ((2) * (2)) ==> 4, x = 4
        printf("%d 的平方为 %d \n", x, SQUARE(x));
        x++;
    }

    return 0;
}