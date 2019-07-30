#include <stdio.h>

int main(){

	char *sz = "0x123456789"; 
	int *p = (int*)sz; 
  	printf("%x\n",*++p); 
  
   	int a = 0x12345678;
    	char *p1 = (char*)(&a);
   	 printf("%x\t%x\t%x\t%x\n",*(p1),*(p1+1),*(p1+2),*(p1+3));

	return 0;	
}

