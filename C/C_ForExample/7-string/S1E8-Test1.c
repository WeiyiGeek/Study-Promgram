#include <stdio.h>

int main(){
	char name[256];  //��scanf ��ʱ�����ָ���ַ����ӵ��ڴ��С 
	float height,weight;
	printf("�������������:");
	scanf("%s",&name);
	printf("������������(CM):");
	scanf("%f",&height);
	printf("�������������(kg):");
	scanf("%f",&weight);

	//printf("%s,%.2f,%.2f",name,height,weight);
	printf("���ڽ���ת����Please Wait!!!\n\n");
	
	height = height / 2.54; //cm->�ߴ� 
	weight = weight / 0.453; // kg->�� 
	
	printf("%s�������%.2f(inches),������%.2f(pound)\n",name,height,weight); 
	return 0;
}
