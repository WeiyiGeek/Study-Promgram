#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int a, b,result;
	printf("输入两个值：");
	scanf("%d %d",&a,&b);
	result = a + b;
	printf("程序开启\n");
	printf("a+b=%d\n",result);
	if(result > 0){
		exit(EXIT_SUCCESS);	
	}else{
		exit(EXIT_FAILURE); 
	}
	 
	printf("程序结束\n -- 永远不显示");
	return 0;	
}



