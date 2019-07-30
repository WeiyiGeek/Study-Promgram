#include <stdio.h>
#include <stdlib.h>

int main(void)
{
        FILE *fp;
        int count=0;

        if ((fp = fopen("c:\\text.txt", "r")) == NULL){
                printf("打开文件失败！\n");
                exit(EXIT_FAILURE);
        }

        while (getc(fp) != EOF){
                count++;
        }
        
        fclose(fp);
        printf("text.txt:文件中一共有%d个字符!\n",count);
        return 0;
}