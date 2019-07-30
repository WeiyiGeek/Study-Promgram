#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    FILE *in, *out;
    int ch;

    if (argc != 3)
    {
        fprintf(stderr, "Usage:copyFile.exe source destination");
        exit(EXIT_FAILURE); //��Ҫstdlib��
    }

    if ((in = fopen(argv[1], "rb")) == NULL)
    {
        fprintf(stderr, "Open %s Fail!!\n", argv[1]);
        exit(EXIT_FAILURE);
    }
    else if ((out = fopen(argv[2], "wb")) == NULL)
    {
        fprintf(stderr, "open %s Fail##\n", argv[2]);
        fclose(in); //ֵ��ѧϰ
        exit(EXIT_FAILURE);
    }

    // eof = -1 ʵ���Ͼ���һ���궨��,����EOF����Ƕ�ȡ���ļ�ĩβ���߶�д�ļ������г��ִ���
    while ((ch = getc(in)) != EOF)
    {
        if (putc(ch, out) == EOF)
        {
            break;
        }
    }

    //�ж�EOF��Ǵ��Ƿ���������
    if (ferror(in))
    {
        fprintf(stderr, "%s Read Fail��\n", argv[1]);
    }
    if (ferror(out))
    {
        fprintf(stderr, "%s Write Fail \n", argv[2]);
    }
    //�ͷ��ڴ�ռ�
    fclose(in);
    fclose(out);

    return 0;
}