#include <sys/types.h>
#include <sys/socket.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ioctl.h>
#include <netdb.h>
#include <netinet/in.h>

//#define HOST "10.7.45.38"
//#define PORT 8080
#define BUFFER_SIZE 1024

int main(int argc,char **argv)
{

	int sockfd, bytes;
	char buf[BUFFER_SIZE];
	struct hostent *host;  //gethostbyname() 传入到该结构体
	struct sockaddr_in serv_addr;

	if(argc != 3){
		fprintf(stderr, "Usage : %s ServerIP PORT\n",argv[0] );
		exit(-1);
	}

	//Step1：查看是不是能从主机名正常获取地址
	if((host = gethostbyname(argv[1])) == NULL){
		perror("gethostbyname");
		exit(1);
	}

	//Step2:建立socket连接 ipv4 tcp 并设置服务端ip 与 port
	if((sockfd = socket(AF_INET,SOCK_STREAM,0)) == -1){
		perror("socket");
		exit(1);
	}

	serv_addr.sin_family = AF_INET;
	serv_addr.sin_port = htons(atoi(argv[2]));
	serv_addr.sin_addr = *((struct in_addr *)host->h_addr); //注意多一层解引用,且是主机序
	bzero(&(serv_addr.sin_zero), 8);  //使其与sockaddr 大小保持一致



//step3:连接服务端
	if(connect(sockfd, (struct sockaddr *)&serv_addr,sizeof(struct sockaddr)) == -1){
		perror("connect");
		exit(1);
	}

//循环读取次
	memset(buf, 0, sizeof(buf));
	int i=0;
	while(i<5){
	bytes = read(sockfd,buf,100);
	if(bytes < 0){
		printf("Read Fault!");
		return -1;
	}else if(0 == bytes){
		printf("Server close Connection!");
	}else{
			printf("Read bytes %d\n", bytes);
			printf("Time:%s\n", buf);
	}
	i++;
	}
	close(sockfd);
	exit(0);
}
