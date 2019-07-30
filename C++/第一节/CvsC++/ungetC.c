#include <stdio.h>
/**
	ungetc() 函数使用方法 
**/ 
int main(void){
	int i;
	int sum = 0;
	char ch;
	
	printf("请输入一串整数与任意数目的空格: "); 
	while(scanf("%d",&i) == 1){
		sum += i;
		
		while((ch=getchar()) == ' '){ //屏蔽空格(值得学习) 
			;
		}
		if(ch == '\n'){
			break;
		}
		
		ungetc(ch,stdin);  //将ch变量中存放的字符返还给标准stdin输入流 
	};
	
	printf("结果为:%d\n",sum);
	return 0;
} 
