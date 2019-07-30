#include <stdio.h>
#include <string.h>

int main(){
	char dest[100] = "Hello ";
	char src1[12]=",Wrold C++";
	char src2[]=",Wrold C ";

	strcat(dest,src1);
	printf("strcat:%s\n",dest);

	strncat(dest,src2,6);
	printf("strncat:%s\n\n",dest);
	
		
	strncat(src1,src2,6);
	printf("没有设置src1坑位的情况下src1字符为:%s\n",src1);
	return 0;

}


