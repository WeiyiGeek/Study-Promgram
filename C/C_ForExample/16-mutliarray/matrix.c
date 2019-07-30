#include <stdio.h>

int main(){
	int score[4][5]={
		{80,92,85,86,99},
		{78,65,89,70,99},
		{67,78,76,89,99},
		{88,68,98,90,99}
	};
	int i,j;
	printf("正常成绩的二维数组:\n");
	for(i=0;i<4;i++){
		for(j=0;j<5;j++){
			printf("%2d ",score[i][j]);
		}
		putchar('\n');
	}
	printf("matrix转置的二维数组:\n");
	int a,b;
	for(a=0;a<5;a++){
		for(b=0;b<4;b++){
			printf("%2d ",score[b][a]);
		}
		putchar('\n');
	}
	
}
