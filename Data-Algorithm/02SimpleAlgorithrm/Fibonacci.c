#include <stdio.h>
//����ʵ��Fibonacci���� 

int main(void)
{
	int f1 = 1, f2 = 1, f3 = 0; 
	int i,n;
	printf("������Ҫ���ɵ�Fibonacci���еĸ�����");
	scanf("%d",&n);
	putchar('\n');
	
	printf("��������Ϊ��%d %d",f1,f2);
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
