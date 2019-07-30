#include <stdio.h>
//迭代实现Fibonacci数列 

int main(void)
{
	int f1 = 1, f2 = 1, f3 = 0; 
	int i,n;
	printf("请输入要生成的Fibonacci数列的个数：");
	scanf("%d",&n);
	putchar('\n');
	
	printf("生成数列为：%d %d",f1,f2);
	for(i = 0 ; i < n - 2; i++)
	{
		f3 = f2 + f1;
		printf(" %d ",f3);
		f1 = f2;
		f2 = f3;
	}

	putchar('\n'); 
	return 0;
}
