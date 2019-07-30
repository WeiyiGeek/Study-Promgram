#include <stdio.h>

int main(){
	int count = 0;
	printf("请输入一串字符:");
	
	 //getchar(); //获取字符 
	while(getchar() != '\n'){
		count+=1;
	}
	printf("你输入的总的字符数为:%d",count);
} 
