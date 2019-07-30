#include <stdio.h>
//signed 与 unsigned 限定符号数据长度 
int main(){
	short a;
	unsigned short b;
	
	int c;
	unsigned int d;
	
	long e;
	unsigned long f;
	
	long long g;
	unsigned long long h;
	printf("/*******signed 与 unsigned 限定符号数据长度********/\n");
	printf("signed short int:%d B\n",sizeof(a));
	printf("unsigned short int:%d B\n\n",sizeof(b));
	
	printf("signed int:%d B\n",sizeof(c));
	printf("unsigned int:%d B\n\n",sizeof(d));
	
	printf("signed long int:%d B\n",sizeof(e));
	printf("unsigned long int:%d B\n\n",sizeof(f));
	
	printf("signed long long int:%d B\n",sizeof(g));
	printf("unsigned long long int:%d B\n\n",sizeof(h));
	
	return 0;
} 

