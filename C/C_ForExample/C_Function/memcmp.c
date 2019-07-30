#include <stdio.h>
#include <string.h>

int main(void)
{
    char str1[10],str2[10];
    int result;
    printf("请输入两个字符串的值：\n");
    printf("字符串 str1 ： ");
    scanf("%s",str1);
    printf("字符串 str2 ： ");
    scanf("%s",str2);
	  result = memcmp(str1, str2, 10);  //对比这两个字符串的前10个字节(及前10个字符)
    if(result == 0){
        printf("str1 与 str2 是内存空相等的\n");
    } else {
        printf("str1 与 str2 的内存空间是不同\n");
    }

    return 0;
}
