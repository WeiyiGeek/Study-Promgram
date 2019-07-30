#include <stdio.h>
#include <time.h>

int main(void)
{
        time_t seconds;

        // 下面语句也可以写成：time(&seconds);
        seconds = time(&seconds);

        printf("1970年1月1日零点到现在经过了%ld秒！\n", seconds);

        return 0;
}
