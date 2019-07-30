#include <stdio.h>
#define MAX 1024

int main(){
	char str1[2 * MAX];   // 确保连接后不越界 设置数组坑位大小
	char str2[MAX];
	
	char *chstr1 = str1;
	char *chstr2 = str2;
	
	printf("String first:");
	fgets(str1,MAX,stdin);
	
	printf("String seconde:");
	fgets(str2,MAX,stdin);
	
	printf("\n------------正在拼接字符串--------------\n");
	
	while (*chstr1++ != '\0')  // 将指针指向 str1 的末尾处 ,target指向 '\0' 的地址
		;
	chstr1 -= 2;    // 我们希望 str1 最后边的 '\0' 和 '\n' 都被覆盖掉
	
	while ((*chstr1++ = *chstr2++) != '\0')  // 在str1 去掉'\0','\n'后再连接字符串str1
		;
		
	printf("输出的拼接字符串：%s",str1);
	return 0;
}


