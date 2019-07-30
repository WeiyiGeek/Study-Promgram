#include <stdio.h>

#define MAX 1024
int main(){
	
	int cnt = 0;
	char test[MAX];
	
	printf("请输入字符串：");	
	fgets(test,MAX,stdin);
	
//method 3: 
	char (*p)[3] = (char (*)[3])test;
	for(int i = 0; i < 3; i++){
		for(int j = 0; j < 3; j++){
			printf("%c ",p[i][j]);
		}
		putchar('\n');
	}


#if 1
//Method 1:	
	char *pa = test;
	for(int i = 0;i < 9;i++){
		cnt += 1;
		printf("%c	",*(pa+i));
		if (cnt == 3){
			cnt = 0;  //下一次置位1 
			putchar('\n');
		}
	}


//method 2: 
	char ch;
	while((ch = *pa++) != '\0'){
		cnt += 1; 
		printf("%c ",ch);
		if(cnt % 3 == 0){
			putchar('\n');
		}
		if(cnt == 9){
			break;
		} 
		

	}
#endif	
}


