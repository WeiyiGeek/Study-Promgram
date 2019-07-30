#include <stdio.h>
/**不同的系统,可能占用的字节不同**/ 

int main(){
	//整型数据长度 
	short int a;
	int b;
	long int c;
	long long int d;
	
	printf("/******整型数据长度********/\n"); 
	printf("shor int 占用的字节：%d B\n",sizeof(a));
	printf("int 占用的字节：%d B\n",sizeof(b));
	printf("long int 占用的字节：%d B\n",sizeof(c));
	printf("long long int 占用的字节：%d B\n\n",sizeof(d));

	//浮点数的数据长度
	float f;
	double db;
	long double ldb;
	
	printf("/******浮点型的数据长度********/\n"); 
	printf("float 占用的字节：%d B\n",sizeof(f));
	printf("double 占用的字节：%d B\n",sizeof(db)); 
	printf("long double 占用的字节：%d B\n\n",sizeof(ldb));  
	
	//字符型的数据长度 
	char ar;
	printf("/******字符型的数据长度********/\n"); 
	printf("char 占用的字节：%d B\n\n",sizeof(ar));
	
	printf("/******布尔型的数据长度********/\n"); 
	printf("_Bool 占用的字节：%d B\n",sizeof(_Bool));

	
	return 0;	
}

