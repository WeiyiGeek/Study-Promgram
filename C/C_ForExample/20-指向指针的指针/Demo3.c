#include <stdio.h>

int main(){

	int array[3][4] = {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12}
		};
	int (*p)[4] = array;
	//int **p = array 输出的长度是不一样的 p+1 = +4, array + 1 =+16跨一整行
	int i,j;

	for(i = 0; i < 3; i++){
		for(j = 0; j < 4; j++){
			printf("%4d",*(*(p + i) + j));
		}
			putchar('\n');
	}
}
