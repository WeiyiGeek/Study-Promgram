#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[]){
    char cmd[1024]="copy ";

    if(argc != 3){
        fprintf(stderr,"Usage:copyFile.exe source destination");
        exit(EXIT_FAILURE);
    }

    fprintf(stdout,"正在将%s文件复制到文件%s\n",argv[1],argv[2]);
    strcat(cmd, argv[1]);
    strcat(cmd," ");
    strcat(cmd, argv[2]);
    fprintf(stdout,"commands = %s\n",cmd);
    system(cmd);
    return 0;
}
