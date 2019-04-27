/**父子进程的共享资源**/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int global = 1;   //global variable, stored at data section

int main(void)
{
    int stack = 1; //local variable, stored at stack
    pid_t pid = vfork();

    if(pid < 0)
    {
        perror("Vfork Error");
        exit(1);
    }
    else if(pid == 0)  //子进程会被先执行
    {
        global++;
        stack++;
        printf("Child-Process,pid = %u, global=%d, stack=%d\n",getpid(),global,stack);
 	    //execl("/root/demo2","./demo2",NULL);  //子进程中另起一个新进程 (会导致循环执行)
	    exit(0);  //子进程需手动退出
    }
    else
    {
	   sleep(2);  //父进程延迟2秒执行
        global++;
        stack++;
        printf("Parent-Process,pid = %u, global=%d, stack=%d\n",pid,global,stack);
     }
   return 0;
    
}
