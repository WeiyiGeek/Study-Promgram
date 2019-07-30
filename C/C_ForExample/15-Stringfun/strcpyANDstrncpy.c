#include <stdio.h>
#include <string.h>
/**strcpy和strncpy函数异同：*/
int main(){
	char dest[] = "Hello,World!";
	char src1[20];
	char src2[20];
	char src3[20];
	
	strcpy(src1,dest);

	strncpy(src2,dest,5);
	src2[5] = '\0';

	strncpy(src3,dest,6);
	
	printf("dest:%s\n\n",dest);
	printf("src1-strcpy():%s\n",src1);
	printf("  加入'\\0'的 src2-strncpy():%s\n",src2);
	printf("未加入'\\0'的 src3-strncpy():%s\n",src3);

	return 0;
	
}
