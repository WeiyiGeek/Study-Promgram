#include <stdio.h>
#include <string.h>
struct cat {
	char name[32];
	char sex[32];
	double weight;
	double leng;
	char color;
};

void main(void){

	struct cat xh; //�ṹ���ÿһ����Ա���г�ʼ��
	strcpy(xh.name,"test");  //���ϵ���ܷ��ʽṹ������ĳ�Ա
	strcpy(xh.sex,"girl");
	xh.leng = 23.5;

	printf("name:%s\nsex:%s\nlength:%d\n",xh.name,xh.sex,xh.leng );
}
