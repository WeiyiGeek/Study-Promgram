#include <stdio.h>

int main(){
	char *test[5];
	char *(*pt)[5] = &test;
	
	printf("ÇëÊäÈë×Ö·û´®£º");
	for (int i = 0; i< 5; i++){
		scanf("%s",*(*pt)[i]);
	} 

	
	for(int a = 0; a < 5; a++){
		for(int b = 0;(*pt)[a][b] != '\0'; b++){
			printf("%c ",(*pt)[a][b]); 
		}
	} 
	printf("\n");
} 

