#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/ioctl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <netinet/in.h>
//#include <winsock.h>

#define BUFFER_SIZE 1024
#define MAX_QUE_CONN_CUNT 5

int main(int argc,char **argv)
{
  struct sockaddr_in serv_socketaddr,cli_socketaddr;
  int sin_size,recv_bytes;
  int sockfd,clientfd;  //socket 与 accept 标识符
  ulong address;
  unsigned short int port;
  char buf[BUFFER_SIZE];

  if(argc < 3){
    printf("Usage:%s ServerIP SERVERPORT\n", argv[0]);
    return -1;
  }
  address = inet_addr(argv[1]); //转成主机序
  port = atoi(argv[2]);

//Step1：建立socket连接
  if((sockfd = socket(AF_INET,SOCK_STREAM,0)) == -1)  //ipv4 tcp协议
  {
    perror("socket create failure!");
    exit(-1);
  }
  printf("Socketfd id = %d\n",sockfd);


//step2：设置sockaddr_in结构体中相关的参数
serv_socketaddr.sin_family = AF_INET;
serv_socketaddr.sin_port = htons(port);
serv_socketaddr.sin_addr.s_addr = address;  // INADDR_ANY = 0.0.0.0 （主机序）
bzero(&(serv_socketaddr.sin_zero),8);  //填充0以保持struct sockaddr 通用的大小 一共14字节


//step3 ：使得重复使用本地地址与套接字进行绑定
int i = 1;
setsockopt(sockfd,SOL_SOCKET,SO_REUSEADDR, &i, sizeof(i));


//step4: 绑定bind函数
  if(bind(sockfd,(struct sockaddr *)&serv_socketaddr,sizeof(struct sockaddr)) == -1)
  {
    perror("bind failure");
    exit(1);
  }
  printf("Bind success!\t Serverip:Serverport -> %s:%d\n",inet_ntoa(serv_socketaddr.sin_addr.s_addr),port);


//step5:绑定listen函数
  if(listen(sockfd,MAX_QUE_CONN_CUNT) == -1)
  {
    perror("Listen Filaure");
    exit(1);
  }
  printf("Listenning.....\n");


//step6：调用accept函数,等待客户端的连接
  if((clientfd = accept(sockfd,(struct sockaddr *)&cli_socketaddr,&sin_size)) == -1)
  {
    perror("accept failure");
    exit(1);
  }

//step7：调用recv函数接收客服端的请求
memset(buf,0,sizeof(buf));
  if((recv_bytes = recv(sockfd,buf,BUFFER_SIZE,0)) == -1)
  {
    perror("recv failure");
    exit(1);
  }

  printf("Received a message: %s \n",buf);
  close(sockfd);
  return 0;
}
