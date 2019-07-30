#include <stdio.h>
int main(){
	char *arr[5] = {"Fishc","Five","star","good","Wow"};
	char *(*pa)[5] = &arr; //数组指针的指针 
	int i,j;
	for(i = 0; i < 5; i++){
		for(j = 0;j < 5;j++){
			if((*pa)[j][i] == '\0')   //精辟之处 00 
				break;
			printf("%c ",(*pa)[j][i]);
			//printf("%c ",arr[i][j]);
		}
		putchar('\n');
	}
	
	
	return 0;
}


