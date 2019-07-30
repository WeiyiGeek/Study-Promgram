#include <stdio.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <sys/socket.h>

int main(int argc,char **argv)
 {
  char *ptr,**pptr;
  char str[INET_ADDRSTRLEN];
  struct hostent *hptr;
  struct in_addr *addr;   //由于没进行ntop字节/ *地址是网络字节序* /
  struct sockaddr_in saddr;

  if(argc != 2){
        printf("Usage: %s ip\n",argv[0]);
        return -1;
  }

  ptr = argv[1];
  if(!inet_aton(ptr,&saddr.sin_addr))  //调用inet_aton()，将ptr点分十进制转in_addr
  {
     printf("Inet_aton error\n");
     return 1;
  }

  if((hptr=gethostbyaddr((void *)&saddr.sin_addr,4,AF_INET))==NULL) //把主机信息保存在hostent中,采用的 sockaddr_in 结构体
  {
    printf("gethostbyaddr error for addr:%s\n",ptr);
    printf("h_errno %d\n",h_errno);
    return 1;
  }
  printf("official hostname: %s\n",hptr->h_name); //正式主机名

  for(pptr=hptr->h_aliases;*pptr!=NULL;pptr++) //遍历所有的主机别名
    printf("\talias: %s\n",*pptr);

  switch(hptr->h_addrtype)//判断socket类型
  {
  case AF_INET:  //IP类为AF_INET
  case AF_INET6:  //IP类为AF_INET6
  pptr=hptr->h_addr_list; //IP地址数组
  for(;*pptr!=NULL;pptr++)
    printf("\taddress: %s\n",inet_ntop(hptr->h_addrtype,*pptr,str,sizeof(str)));//inet_ntop转换为点分十进制
    break;
  default:printf("unknown address type\n");
    break;
   }
 return 0;
}
