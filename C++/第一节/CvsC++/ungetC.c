#include <stdio.h>
/**
	ungetc() ����ʹ�÷��� 
**/ 
int main(void){
	int i;
	int sum = 0;
	char ch;
	
	printf("������һ��������������Ŀ�Ŀո�: "); 
	while(scanf("%d",&i) == 1){
		sum += i;
		
		while((ch=getchar()) == ' '){ //���οո�(ֵ��ѧϰ) 
			;
		}
		if(ch == '\n'){
			break;
		}
		
		ungetc(ch,stdin);  //��ch�����д�ŵ��ַ���������׼stdin������ 
	};
	
	printf("���Ϊ:%d\n",sum);
	return 0;
} 
