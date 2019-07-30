#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main(){
  struct sockaddr_in foo;
  char *str = "127.0.0.1";
  char str1[32];
  inet_pton(AF_INET,str,&foo.sin_addr);  //代替 foo.sin_addr.addr=inet_addr(ip);

  inet_ntop(AF_INET,&foo.sin_addr,str1,sizeof(str1)); //代替 ptr = inet_ntoa(foo.sin_addr)
  printf("pton(127.0.0.1):%d\n", foo.sin_addr); //主机字节顺序
  printf("ntop(16777343):%s\n", str1);
  return 0;
}
