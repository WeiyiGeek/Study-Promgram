#include <stdio.h>
#include <stdlib.h>

int main(void)
{
        FILE *fp;
        int count=0;

        if ((fp = fopen("c:\\text.txt", "r")) == NULL){
                printf("���ļ�ʧ�ܣ�\n");
                exit(EXIT_FAILURE);
        }

        while (getc(fp) != EOF){
                count++;
        }
        
        fclose(fp);
        printf("text.txt:�ļ���һ����%d���ַ�!\n",count);
        return 0;
}