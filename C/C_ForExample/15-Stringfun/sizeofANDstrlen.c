#include <stdio.h>
#include <string.h>
/*sizeof()与strlen()函数的不同*/
int main(){
	printf("sizeof是表示数组坑位的大小,数组中字符串的长度,不保留'\\0'\n");
	char Test[20]= "Hello,World!";
		
	printf("sizeof()=%d\n",sizeof(Test));
	printf("strlen()=%u\n",strlen(Test));
	
	
	printf("\nsizeof会把'\\0'进行加上到长度中,而strlen不会包括'\\0'\n");

	char Demo[] = "Hello,World!";
	printf("sizeof()=%d\n",sizeof(Demo));
	printf("strlen()=%u\n",strlen(Demo));
 

	return 0;
}
