#include <stdio.h>

int main(){
	char str[] = "I love qq.com";
	char *target = &str[0];
	
	int count = 0;
	
	//while(*str++ != '\0')  由于str是一个数组名，不能作为lvalue  
	while(*target++ != '\0'){   // *取值 target，需要注意的是++ 在本次执行就是target本身,（生效）下一次才是target+1. 
		count++;
	}
	
	printf("本次共输出了 %d 个字符!\n",count);
	return 0; 
}

