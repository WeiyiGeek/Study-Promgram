#include <stdio.h>
#include <string.h>

int main(void)
{
    char str[10] = "www.qq.com";
    int len;
    printf("输入查找的范围 ：");
    scanf("%d",&len);
    if(memchr(str,'q',len) != NULL)
    {
      printf("已找到字符q\n");
    }
    else
    {
      printf("未找到字符q\n");
    }

    return 0;
}
