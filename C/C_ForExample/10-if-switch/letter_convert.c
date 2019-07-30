#include <stdio.h>

int main(){
	char letter;

	printf("请输入一个大小写字母："); 
	scanf("%c",&letter);
	if(( letter >= 65 && letter <= 90) || (letter >=97 && letter <=122)){
		if( letter >= 65 && letter <= 90){
			printf("你输入的大写字母是%c,转换成小写字母是%c\n",letter,letter+32); 
		}else{
			printf("你输入的小写字母是%c,转换成大写字母是%c\n",letter,letter-32);
		}		
	}else{
		printf("请正确输入一个大小写字母：\n");
	}

}
