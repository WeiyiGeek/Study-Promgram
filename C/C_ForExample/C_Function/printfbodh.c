#include <stdio.h>
#include <stdlib.h>
int main(){
    int n;
    scanf("%d",&n);
    printf("转换的进制为：\n");
    printf("octal:%o\n",n);
    printf("decimal:%u\n",n);
    printf("hexadecimal:%x\n",n);
    printf("--------------------单独打印二进制--------------------------\n");
    char buffer[33];		 //必须的 
    	itoa(n,buffer,2);
    	printf("Binary=%s\n",buffer);
    
    return 0;
}
