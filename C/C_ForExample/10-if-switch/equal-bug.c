#include <stdio.h>
int main(){
	char hasBF;
	
	printf("С��������������(y/n)\n");
	scanf("%c",&hasBF);
	
//	if(hasBF = 'Y')  ע������,�ǽ�һ������Y��ֵ��һ�� hasBF����,if������ϵ���ʽ���ж�ֻҪ��0��Ϊ�� 
	if('y' == hasBF)   //���� �ж��Ƿ� ֵ��ȡ�����ѳ���д��ǰ�� ������д�ں���,�������� = ���ֵ�BUG�� 
	{ 
		printf ("ף�����ǣ���T_T!!"); 
	} else{
		printf("������һ��ѣ���"); 
	}
	
	return 0; 
}
