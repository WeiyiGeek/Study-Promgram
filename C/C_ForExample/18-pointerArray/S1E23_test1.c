#include <stdio.h>
int main(){
	char *arr[5] = {"Fishc","Five","star","good","Wow"};
	char *(*pa)[5] = &arr; //数组指针的指针 
	int i,j;
	for(i = 0; i < 5; i++){
		for(j = 0;(*pa)[i][j] != '\0';j++){
			printf("%c ",(*pa)[i][j]);
			//printf("%c ",arr[i][j]);
		}
		putchar('\n');
	}
	
	
	return 0;
}


