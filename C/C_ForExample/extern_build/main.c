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
    printf("������һ���ַ� ��");
    enter_str(str);              //��������
    printf("����Ҫɾ�����ַ� ��");
    scanf("%c",&c);
    delete_str(str,c);      //ɾ��ָ���ַ�
    printf("\n���ڴ�ӡɾ����� ��\n");
    printf_str(str);
    putchar('\n');
    return 0;
}
