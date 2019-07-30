#include <stdio.h>
#include <stdlib.h>

int main(void)
{
        FILE *fp;
        int ch;

        if ((fp = fopen("read_hello.txt", "r")) == NULL)
        {
                printf("打开文件失败！\n");
                exit(EXIT_FAILURE);
        }

        while (1)
        {
                ch = fgetc(fp);

                if (feof(fp))   //这样写都不会,多打印一次最后一个字符了
                {
                        break;
                }

                putchar(ch);
        }

        fclose(fp);
        return 0;
}
