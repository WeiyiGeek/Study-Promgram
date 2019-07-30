#include <stdio.h>
#define STR(S) # S  //变成字符串
#define CONSTR(x,y) x ## y   //连接实参X,Y
int main(void)
{
    printf(STR(Hello    %s Pragram %d\n), STR(C), 520); //注意里面不能有STR(,)号
    printf("x,y连接后 %d \n",CONSTR(5,20));
    return 0;
}