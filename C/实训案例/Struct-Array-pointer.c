#include <stdio.h>
#include <string.h>

struct cat {
	char name[32];
	char sex[32];
	double weight;
	double leng;
	char color[10];
};

void main(void){

	struct cat xh; //�ṹ���ÿһ����Ա���г�ʼ��
	struct cat xha[10];  //����һ���ṹ������
	int a = 1;
	int *pa = &a;  //����һ��ָ��

	struct cat *pcat = &xh;
	pcat -> weight = 56.4;  //ָ����ṹ��ķ�����ʽ '->'
	strcpy(pcat->color,"blue");

	strcpy(xh.name,"test");  //���ϵ�"." ���ܷ��ʽṹ������ĳ�Ա
	strcpy(xh.sex,"girl");
	xh.leng = 23.5;


	for (int i = 0; i < 10; i++) {
			strcpy(xha[i].name,"xiaohuahua"); //���ڽṹ������
			xha[i].weight = i + 56.4;
	}
	for (int i = 0; i < 10; i++) {
		printf("xha[i].name:%s\txha[i].weight:%f\n",xha[i].name,xha[i].weight);
	}


	printf("name:%s\tsex:%s\tlength:%.2f\tweight:%.2f\tcolor:%s\t",xh.name,xh.sex,xh.leng,pcat->weight,pcat->color);
}
