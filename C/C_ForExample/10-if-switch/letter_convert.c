#include <stdio.h>

int main(){
	char letter;

	printf("������һ����Сд��ĸ��"); 
	scanf("%c",&letter);
	if(( letter >= 65 && letter <= 90) || (letter >=97 && letter <=122)){
		if( letter >= 65 && letter <= 90){
			printf("������Ĵ�д��ĸ��%c,ת����Сд��ĸ��%c\n",letter,letter+32); 
		}else{
			printf("�������Сд��ĸ��%c,ת���ɴ�д��ĸ��%c\n",letter,letter-32);
		}		
	}else{
		printf("����ȷ����һ����Сд��ĸ��\n");
	}

}
