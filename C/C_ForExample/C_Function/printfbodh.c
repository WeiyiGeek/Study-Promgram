#include <stdio.h>
#include <stdlib.h>
int main(){
    int n;
    scanf("%d",&n);
    printf("ת���Ľ���Ϊ��\n");
    printf("octal:%o\n",n);
    printf("decimal:%u\n",n);
    printf("hexadecimal:%x\n",n);
    printf("--------------------������ӡ������--------------------------\n");
    char buffer[33];		 //����� 
    	itoa(n,buffer,2);
    	printf("Binary=%s\n",buffer);
    
    return 0;
}
