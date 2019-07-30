#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    FILE *in, *out;
    int ch;

    if (argc != 3)
    {
        fprintf(stderr, "Usage:copyFile.exe source destination");
        exit(EXIT_FAILURE); //需要stdlib库
    }

    if ((in = fopen(argv[1], "rb")) == NULL)
    {
        fprintf(stderr, "Open %s Fail!!\n", argv[1]);
        exit(EXIT_FAILURE);
    }
    else if ((out = fopen(argv[2], "wb")) == NULL)
    {
        fprintf(stderr, "open %s Fail##\n", argv[2]);
        fclose(in); //值得学习
        exit(EXIT_FAILURE);
    }

    // eof = -1 实际上就是一个宏定义,出现EOF情况是读取到文件末尾或者读写文件过程中出现错误
    while ((ch = getc(in)) != EOF)
    {
        if (putc(ch, out) == EOF)
        {
            break;
        }
    }

    //判断EOF标记处是否不正常结束
    if (ferror(in))
    {
        fprintf(stderr, "%s Read Fail！\n", argv[1]);
    }
    if (ferror(out))
    {
        fprintf(stderr, "%s Write Fail \n", argv[2]);
    }
    //释放内存空间
    fclose(in);
    fclose(out);

    return 0;
}