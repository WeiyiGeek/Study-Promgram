#include <stdio.h>
void main()
{
	long long int i=2,n;
	printf("请输入需要分解的正整数(奇数):");
	n=600851475143;
	printf("分解质因数的结果为:\n%lld=",n);
	while(n>=2)
	{
		if( n % i == 0) {  //质数(素数)就是奇数能整除得到的一些数
			printf("%d*",i);
			n/=i; //得到下一次的n质
		}else{
			i++;
		}
	}
	//13195的质因数(4个)且等于5*7*13*29
	printf("\b \b \n");
	printf("最大的质数因子为等于：%lld\n",i);
}
