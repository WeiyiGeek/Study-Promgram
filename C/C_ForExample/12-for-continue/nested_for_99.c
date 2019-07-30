#include <stdio.h>
//99³Ë·¨±í£¬×óÏÂ
//1*1
//1*2 2*2
int main(){
	int i,j;
	for (i=1;i<10;i++)
	{
		for(j=1;j<=i;j++)
		{
			printf("%d*%d=%-5d",i,j,i*j);
		}
		putchar('\n');
	}
	return 0;
}
