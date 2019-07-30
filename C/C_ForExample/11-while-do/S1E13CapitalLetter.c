#include <stdio.h>

int main(){
	int num=0,ch;
	printf("请输入一句话:");
	while((ch = getchar()) != '\n'){  //这里是个坑,需要赋值下面才能进行IF语句
		if(ch >= 'A' && ch <= 'Z'){
			num=num+1;
		}
	}
	printf("你一种输入了%d个CapitalLtetter！！\n",num);
}
