#include <stdio.h>
#include <netinet/in.h>  //in_addr 结构体
#include <arpa/inet.h>   //inet_*
#include <string.h>

int main(int argc,char **argv)
{
  struct in_addr addr1,addr2,inp;
  ulong a1,a2;
  char str[] = "255.255.255.255";

  if(argc <= 2){
    printf("Usage:%s ip1 ip2\n", argv[0]);
    return -1;
  }

  inet_aton(argv[1],&inp);   //34344056 = 120.12.12.2
  a2 = inet_addr(argv[2]);   //16777343  = 1.0.0.127

   printf("param1：%d\n",inp.s_addr);
   printf("param2: %ld\n",a2);
  //地址拷贝
  memcpy(&addr1,&inp.s_addr,4);
  memcpy(&addr2,&a2,4);

   printf("%s : %s\n", inet_ntoa(addr1), inet_ntoa(addr1)); //注意这一句的运行结果,会直接覆盖(addr2s) 表面了printf是从右向左执行
   printf("ntoa(addr1): %s\n", inet_ntoa(addr1));
   printf("ntoa(addr2): %s\n", inet_ntoa(addr2));

//补充一点
  a1 = inet_addr(str);
  if(-1 == a1){
    printf("inet_addr return -1 when 255.255.255.255\n");
  }

   return 0;
}
