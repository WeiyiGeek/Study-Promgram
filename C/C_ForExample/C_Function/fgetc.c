#include <stdio.h>
#include <stdlib.h>

int main(){
        FILE *fp;
        int ch;

        if ((fp = fopen("c:\\text.txt", "r")) == NULL){
                printf("���ļ�ʧ�ܣ�\n");
                exit(EXIT_SUCCESS);
        }

        while ((ch = fgetc(fp)) != EOF){    
                putchar(ch);
                printf("  ");
        }
        fclose(fp);
        return 0;
}