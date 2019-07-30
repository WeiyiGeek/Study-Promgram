#include <stdio.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <stdlib.h>
#include <string.h>

int main(int argc,char ** argv)
{
  struct in_addr addr1,addr2;
  unsigned long int a1,a2;
  if(argc != 3){
    printf("Usage:%s ip ip\nnetwork <-> host Byte Order \n", argv[0]);
    return -1;
  }

  a1 = inet_addr(argv[1]);
  a2 = inet_addr(argv[2]);
  printf("输入的主机：Param1:%s  Param2:%s\n",argv[1],argv[2]);
  printf("主机序(小端)：Param1：%u \t  Param2：%u\n",a1,a2);

  memcpy(&addr1,&a1,4);
  memcpy(&addr2,&a2,4);
  a1 = htonl(addr1.s_addr);
  a2 = htonl(addr2.s_addr);
  printf("网络序(大端)：Param1: %u \t Param2: %u\n",a1,a2);  //这里是巨坑 %u 占位符（无符号）

  memcpy(&addr1,&a1,4);
  memcpy(&addr2,&a2,4);
  printf("ntoa(addr1-网络序输出IP): %s\n", inet_ntoa(addr1));  //必须调用in_addr结构体
  printf("ntoa(addr2-网络序输出IP): %s\n", inet_ntoa(addr2));  //在本地采用网络字节序输出与ip地址相反

  a1 = ntohl(addr1.s_addr);  //又转换回主机序
  a2 = ntohl(addr2.s_addr);   //又转换回主机序
  memcpy(&addr1,&a1,4);
  memcpy(&addr2,&a2,4);
  printf("ntoa(addr1-主机序输出IP): %s\n", inet_ntoa(addr1));  //必须调用in_addr结构体
  printf("ntoa(addr2-主机序输出IP): %s\n", inet_ntoa(addr2));  //在本地采用主机字节序输出与ip地址相同
  return 0;
}
