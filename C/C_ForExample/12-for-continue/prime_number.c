#include <stdio.h>

int main(){
	int i,num;
	_Bool flag=1;
	printf("请输入一个数字:");
	scanf("%d",&num);
	for (i=2;i<=num/2;i++)
	{
		if(num % i == 0)
		{
			flag=0;
			break;
		}
	
	}
	if(flag)
	{
		printf("%d“是”一个素数\n",num);
	}else{
		printf("%d“不是”一个素数\n",num);
	}
	
}
