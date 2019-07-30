#include <stdio.h>
#include <netdb.h>
#include <sys/socket.h>

int main(int argc, char **argv)
{
    char   *ptr, **pptr;  //定义主机名 与 主机别名指针变量
    struct hostent *hptr;  //结构体指针
    char str[32] = {0};  //存放ip地址字符串
    ptr = argv[1];  //域名给指针ptr

    if(argc != 2){
      printf("使用帮助:\nUsage:%s url\n",argv[0]);
      return -1;  //直接退出程序
    }

    if((hptr = gethostbyname(ptr)) == NULL)  //判断是否返回正确
    {
        printf(" gethostbyname error for host:%s\n", ptr);
        return 0;
    }

    printf("official hostname:%s\n",hptr->h_name);
    for(pptr = hptr->h_aliases; *pptr != NULL; pptr++)  //获取主机别名
        printf("alias:%s\n",*pptr);

    switch(hptr->h_addrtype)  //判断类型
    {
        case AF_INET:
        case AF_INET6:
            pptr=hptr->h_addr_list; //给指针
            for(; *pptr != NULL; pptr++){
                printf("address:%s\n",inet_ntop(hptr->h_addrtype, *pptr, str, sizeof(str)));
                //inet_ntop: 将网络字节序的二进制转换为文本字符串的格式
            }
            printf("first address: %s\n", inet_ntop(hptr->h_addrtype, hptr->h_addr, str, sizeof(str)));  //#define h_addr h_addr_list[0]   //保存的是IP地址数组 - 第一个元素的地址
        break;
        default:
            printf("unknown address type\n");
        break;
    }

    return 0;
}
