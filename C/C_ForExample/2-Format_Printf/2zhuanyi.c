#include <stdio.h>
/**ת���ַ���Demo**/ 
int main(){
	
	printf("\a");  //������
	printf("Test \bBackspsche\n");   //ɾ��ǰһ���˸�BS������ FF
	printf("Test \fchange Line\n");  //��ҳ����FF-LF
	printf("Test\renter\n");    //�س�CR 
	printf("ˮƽ�Ʊ����\tshuiping\n");  //HT
	printf("��ֱ�Ʊ���ţ�\vCHUIZHI\n");  //VT
	printf("���ת��ķ�б��\\\n"); 
	printf("��ʾ���������\'��˫\"��\?\n");
	printf("������ַ�\0\n");
	printf("����˽��Ƶ��ַ�:\060\n");  //ASCII֮���ת�� 
	printf("���ʮ�����Ƶ��ַ�:\x61\n"); 
	return 0;
}
