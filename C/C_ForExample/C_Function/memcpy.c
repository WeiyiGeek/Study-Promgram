#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    char str[] = "I LOVE STUDY C language";
    //int number[10] = {1,2,3,4,5,6,7,8};
    int len = sizeof(str);           //�����ַ�������� '\0'ռ��24�ֽ� ,���Ƕ�����������(int)������������number[10]��ռ����40�ֽ�
    unsigned int slen = strlen(str); //ֻ�����ַ������Ȳ����� '\0'������Ϊ23.
    char *ptr;

    ptr = (char *)malloc(len * sizeof(char));
    if (ptr == NULL)
    {
        printf("�����ڴ�ʧ��~");
        exit(1);
    }

    memset(ptr, 0, len * sizeof(char));   //����������ڴ�ռ��ʼ��Ϊ0
    memcpy(ptr, str, len * sizeof(char)); //���ص��ڴ��ַ��ptr�ĵ�ַ

    printf("str[] ������ַ���ռ���˿ռ��С ��%d   ,�ַ������� ��%d\n", len, slen);
    printf("memcpy ���������ڴ�ռ���ַ���Ϊ ��%s\n\n", ptr);

    free(ptr);
    return 0;
}
