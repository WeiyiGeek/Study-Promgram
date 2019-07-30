#include <stdio.h>

int main(){
	int array[4][5] = {0};
	int i,j,k=0;
	
	for(i=0;i<4;i++){
		for(j=0;j<5;j++){
			array[i][j] = k++; 	
		}
	}
	

	printf("*(array +1)+3 : %p\n",*(array +1)+3);
	printf("&Arrayp[1][3]: %p\n",&array[1][3]);
	putchar('\n');
	printf("*(*(array+1)+3: %d\n",*(*(array+1)+3));
	printf("array[1][3]: %d\n",array[1][3]);

	return 0;
}
