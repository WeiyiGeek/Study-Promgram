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

	struct cat xh; //结构体对每一个成员进行初始化
	struct cat xha[10];  //定义一个结构体数组
	int a = 1;
	int *pa = &a;  //建立一个指针

	struct cat *pcat = &xh;
	pcat -> weight = 56.4;  //指针与结构体的访问形式 '->'
	strcpy(pcat->color,"blue");

	strcpy(xh.name,"test");  //加上点"." 就能访问结构体里面的成员
	strcpy(xh.sex,"girl");
	xh.leng = 23.5;


	for (int i = 0; i < 10; i++) {
			strcpy(xha[i].name,"xiaohuahua"); //对于结构体数组
			xha[i].weight = i + 56.4;
	}
	for (int i = 0; i < 10; i++) {
		printf("xha[i].name:%s\txha[i].weight:%f\n",xha[i].name,xha[i].weight);
	}


	printf("name:%s\tsex:%s\tlength:%.2f\tweight:%.2f\tcolor:%s\t",xh.name,xh.sex,xh.leng,pcat->weight,pcat->color);
}
