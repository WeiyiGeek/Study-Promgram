#include <stdio.h>
int main(){
	int ch;
	printf("请输入成绩评级(A-E):");
	scanf("%c",&ch);
	
	switch(ch){
		case 'A': printf("你的成绩范围在90分以上！\n");break;
		case 'B': printf("你的成绩范围在80分以上,90分以下\n");break;
		case 'C': printf("你的成绩范围在70分以上,80分以下\n");break;
		case 'D': printf("你的成绩范围在60分以上,70分以下\n");break;
		case 'E': printf("你的成绩范围在60分以下\n");break;
		default : printf("请输入正确的成绩评级!!\n");
	}
	
	return 0;
}
