#include <stdio.h>

int main(){
//	int hs;
 	float hs,ss;
	printf("�����뻪���¶� : ");
//	scanf("%d",&hs);
	scanf("%f",&hs);       //ע�������ռλ����ʽ �����ں�������Ӱ��� 
	//ss = ((float)hs - 32 ) * 5 / 9;
	ss = (hs - 32 ) * 5 / 9;
	printf("ת���������¶��� : %.2f\n",ss);
	
	return 0; 
}
 
