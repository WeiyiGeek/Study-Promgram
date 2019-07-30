#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    char str[] = "I LOVE STUDY C language";
    //int number[10] = {1,2,3,4,5,6,7,8};
    int len = sizeof(str);           //对于字符串会加上 '\0'占用24字节 ,但是对于整型数组(int)不会比如上面的number[10]，占用了40字节
    unsigned int slen = strlen(str); //只会算字符串长度不包括 '\0'，长度为23.
    char *ptr;

    ptr = (char *)malloc(len * sizeof(char));
    if (ptr == NULL)
    {
        printf("分配内存失败~");
        exit(1);
    }

    memset(ptr, 0, len * sizeof(char));   //对于申请的内存空间初始化为0
    memcpy(ptr, str, len * sizeof(char)); //返回的内存地址是ptr的地址

    printf("str[] 数组的字符串占用了空间大小 ：%d   ,字符串长度 ：%d\n", len, slen);
    printf("memcpy 函数拷贝内存空间的字符串为 ：%s\n\n", ptr);

    free(ptr);
    return 0;
}
