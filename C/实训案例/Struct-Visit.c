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

	struct cat xh; //结构体对每一个成员进行初始化
	strcpy(xh.name,"test");  //加上点就能访问结构体里面的成员
	strcpy(xh.sex,"girl");
	xh.leng = 23.5;

	printf("name:%s\nsex:%s\nlength:%d\n",xh.name,xh.sex,xh.leng );
}
