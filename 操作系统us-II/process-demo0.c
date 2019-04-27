/**
 * Linux下的进程标识符
 ***/
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(void)
{
    //进程 process
    pid_t pid=0,ppid=0;
    //用户 user
    uid_t uid=0,euid=0;
    //组 group
    gid_t gid=0,egid=0;

    pid = getpid(); ppid = getppid();
    uid = getuid(); euid = geteuid();
    gid = getgid(); egid = getegid();

    printf("当前进程ID:%u\t,父进程ID:%u\n",pid,ppid);
    printf("用户ID:%u\t,有效用户ID:%u\n",uid,euid);
    printf("组ID:%u\t,有效组ID:%u\n",gid,egid);
}

