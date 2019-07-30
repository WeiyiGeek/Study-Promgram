#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <netdb.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h>

int lookup_host (const char *host);
int lookup_host (const char *host)  //定义一个函数
{
  struct addrinfo hints, *res;
  int errcode;
  char addrstr[100];
  void *ptr;

  memset (&hints, 0, sizeof (hints));
  hints.ai_family = PF_UNSPEC;  //ipv4 与 ipv6 均可
  hints.ai_socktype = SOCK_STREAM;  //tcp
  hints.ai_flags |= AI_CANONNAME;  //同轴gethostbyinfo返回主机名

  errcode = getaddrinfo (host, NULL, &hints, &res);  //传入主机地址, hints可以是一个空指针也可以指向addrinfo结构体
  if (errcode != 0)
    {
      perror ("getaddrinfo");
      return -1;
    }

  printf ("Host: %s\n", host);
  while (res)  //返回addrinfo结构体
    {
      inet_ntop (res->ai_family, res->ai_addr->sa_data, addrstr, 100);  //sa_data14字节的地址协议,包含socket的ip地址(4B)和端口号(2B)

      switch (res->ai_family)
        {
        case AF_INET:
          ptr = &((struct sockaddr_in *) res->ai_addr)->sin_addr;  //源地址 ipv4 获取 sockaddr 结构体里面的ip地址
          break;
        case AF_INET6:
          ptr = &((struct sockaddr_in6 *) res->ai_addr)->sin6_addr; //源地址 ipv6
          break;
        }
      inet_ntop (res->ai_family, ptr, addrstr, 100);
      printf ("IPv%d address: %s (%s)\n", res->ai_family == PF_INET6 ? 6 : 4,
              addrstr, res->ai_canonname);
      res = res->ai_next; //ai_next成员串联起来的addrinfo结构链表
    }

  return 0;
}

int main (int argc, char *argv[])
{
  if (argc < 2){
    printf("Usage:%s url/ip\n",argv[0]);
    return -1;
  }
  return lookup_host (argv[1]);
}
