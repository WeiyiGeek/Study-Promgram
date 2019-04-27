/* 父进程写 子进程读 */
/* waitpid.c 案例应用 */ 
#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include <unistd.h>
#include <fcntl.h> 
#include <sys/wait.h>
#include <sys/types.h>

void ChildRead()
{
	int fd,ret;
	char buf[20] = {0};
 
	fd = open("hello.txt",'r');
	if(-1 == fd)
	{
		perror("ChildRead Error");
		exit(2);
	}
 
	ret = read(fd,buf,sizeof(buf));
	if(-1 == ret)
	{
		perror("File read Error");
		exit(3);
	}
	else
	{
		printf("Read from txt:%s\n",buf);
		memset(buf,0,sizeof(buf));  //清空缓存区
	}
	
	close(fd);
	exit(0);
}
 
 
void ParentWrite()
{
	int fd;
	int ret;
	char buf[20] = {0};
 	system("touch hello.txt");
	fd = open("hello.txt",O_WRONLY | O_CREAT);
	if(-1 == fd)
	{
		perror("Rarent File open write Error!");
		exit(4);
	}
 
	printf("Please input the string:\n");
	scanf("%s",buf);
 
	ret = write(fd,buf,strlen(buf));
	if(-1 == ret)
	{
		perror("write");
		exit(5);
	}
	
	close(fd);
}
 
 
int main()
{
 
	pid_t pid = fork();
	if(-1 == pid)
	{
		perror("fork Error");
		exit(1);
	}
	else if(0 == pid)
	{
		sleep(4);
		ChildRead();
	}
	else
	{
		ParentWrite();
		waitpid(pid,NULL,0); //等待子进程结束,父进程回收
	}
 
	return 0;
}

