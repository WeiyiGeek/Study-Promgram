#include <stdio.h>
#include "menu.h"

int main()
{	int choice;
	printf("welcom you!\n");
	printf("1 music!\n");
	printf("2 picture!\n");
	scanf("%d",&choice);
	switch(choice)
	{	case 1:
			music();
			break;
		case 2:
			picture();
			break;	
	}
	printf("Good Bye!\n");
	return 0;
}
