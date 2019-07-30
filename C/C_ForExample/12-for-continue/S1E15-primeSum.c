#include <stdio.h>
#include <math.h>

int main(){
	int i,j,sum=2;
	
	for(i=5;i<=10000;i++)
	{
					for(j=2;j<=i/2;j++)
					{
							if (i % j == 0){
									sum +=1;
									break;
							}
						}
		}
		sum = 10000 - sum;
		printf("一千以内有%d个素数！\n",sum);
	return 0;
}
