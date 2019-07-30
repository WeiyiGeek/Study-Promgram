#include <stdio.h>

int main(){
	
	int i,j;
	for(i=1;i<10;i++)
	{
		for(j=1;j<10;j++)
		{
				if(j=5)
				{
					break;	
				}
		}	
		
		if(j=5)
		{
			break;
		}
	}	
	
	printf("i = %d,j = %d\n",i,j);
}
