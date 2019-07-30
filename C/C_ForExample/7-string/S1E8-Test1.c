#include <stdio.h>

int main(){
	char name[256];  //在scanf 的时候必须指定字符串坑的内存大小 
	float height,weight;
	printf("请输入你的姓名:");
	scanf("%s",&name);
	printf("请输入你的身高(CM):");
	scanf("%f",&height);
	printf("请输入你的体重(kg):");
	scanf("%f",&weight);

	//printf("%s,%.2f,%.2f",name,height,weight);
	printf("正在进行转换，Please Wait!!!\n\n");
	
	height = height / 2.54; //cm->尺寸 
	weight = weight / 0.453; // kg->磅 
	
	printf("%s的身高是%.2f(inches),体重是%.2f(pound)\n",name,height,weight); 
	return 0;
}
