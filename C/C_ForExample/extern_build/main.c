#include <stdio.h>
#include "file1.c"
#include "file2.c"
#include "file3.c"

int main(void)
{
    extern void enter_str(char str[]);
    extern void delete_str(char str[],char ch);
    extern void printf_str(char str[]);
    char c,str[30];
    printf("请输入一串字符 ：");
    enter_str(str);              //传入数组
    printf("输入要删除的字符 ：");
    scanf("%c",&c);
    delete_str(str,c);      //删除指定字符
    printf("\n正在打印删除结果 ：\n");
    printf_str(str);
    putchar('\n');
    return 0;
}
