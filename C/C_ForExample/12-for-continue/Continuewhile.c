#include <stdio.h>

int main(){
	
	int ch;
	while((ch = getchar()) != '\n')
	{
		if('C' == ch)
		{
			continue;
		}
		putchar(ch);
	}
	putchar('\n');
	return 0;
} 
