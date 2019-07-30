#include <stdio.h>

int main(){

	int num[3][3]={
		{1,2,3},{4,5,6},{7,8,9}
	};
	int i,j;
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("num[%d][%d]=%d   ",i,j,num[i][j]);
		}
		putchar('\n');
	} 
	printf("matrix 转置\n");

	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("num[%d][%d]=%d   ",j,i,num[j][i]); //让j先进行变化成rows
		
		}
		putchar('\n');
	}
	return 0;
}
