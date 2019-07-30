#include <stdio.h>
#define SHOWLIST(...) printf(#__VA_ARGS__)   //把后面的参数都变成字符串
#define PRINF(format, ...) printf(# format, ##__VA_ARGS__)  //连接运算符

int main(void)
{

    SHOWLIST(Hello, World, C.Pragram, 520, 3.14\n);
    PRINF(num = %d\n, 520, 1314);
    //支持空参数
    PRINF(Hello C/JAVA/PHP Pragma!\n);
    return 0;
}