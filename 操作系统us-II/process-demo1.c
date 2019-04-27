/***
 * 进程的创建-fork()
 ****/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int value = 1023; 

int main(void)
{
    pid_t pid =  fork();  //创建新进程的进程，即调用函数fork()的进程就是父进程。
    
    if(pid < 0)
    {
        perror("fork Error");
	exit(1);
    }
    else if(pid == 0)
    {
        value++;    //注意点不会受到父进程改变value值的影响, ,如果这里变成 value+=5 ,这是输出的是 value = 1028 = 1023 + 5
        printf("Child Process -PID:%u  -PPID:%u, (子)创建的第二个进程 %d, Child ID= %d\n\n",getpid(),getppid(),value,pid); 
    exit(0);
    }
    else
    {
        value++;   //注意点
        printf("Parent Process -PID:%u  -PPID:%u, (父)创建的第一个进程 %d,返回子进程PID = %d\n\n",getpid(),getppid(),value,pid);
    	waitpid(pid,NULL,0);  //确保父进程后结束
    }
    
    return 0;
}