#include <stdio.h>
/**Printf������Demo**/ 
int main(){
	int a = 520;
	char b = 'F';
	float c = 3.14;
	double d = 3.141592653;
	
	printf("�ҷǳ���ϲ��C���ԣ���%d���ʱ��\n",a);
	printf("��Ҫ���һ����ĸ��%c\n",b);
	printf("Բ������ֵ��:%.2f\n",c);
	printf("��ȷ��С�����9λ��Բ������:%10.9f\n",d);
    printf("***************************************************************************\n");
    
    printf("���Է���:% f\n",d); 
    printf("���Է���:%+f\n",d);   // �������������� 

    printf("***************************************************************************\n");
	printf("%s\n","Hello World");   //"hello",һ���ַ����洢���ڴ���
	printf("8�İ˽�����:%o\n",8);
	printf("10��ʮ������:%u\n",10);
	printf("15��ʮ��������:%x\n",15);	
	return 0;	
	
} 