#include <stdio.h>
/**通过预处理来定义转义字符并利用字符格式进行输出**/
#define NL '\n'
#define F(n) 2*n

int main(){
	printf("Lines1%c",NL);
	printf("Lines2%c",NL);
	printf("2*n=%d %c",F(3+2),NL);
	return 0;
	
} 
