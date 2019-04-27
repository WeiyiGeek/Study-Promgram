#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

//exit 与 _exit 区别
int main(void)
{
    printf("exit 与 _exit 区别");
    exit(0); //在进程结束之前做了清理工作，刷新缓冲区所以才将字符串显示出来 
    _exit(0);
}
