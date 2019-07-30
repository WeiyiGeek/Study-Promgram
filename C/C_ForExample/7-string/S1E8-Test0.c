#include <stdio.h>

int main(){
//	int hs;
 	float hs,ss;
	printf("请输入华氏温度 : ");
//	scanf("%d",&hs);
	scanf("%f",&hs);       //注意输入的占位符格式 ，对于后面是有影响的 
	//ss = ((float)hs - 32 ) * 5 / 9;
	ss = (hs - 32 ) * 5 / 9;
	printf("转换的摄氏温度是 : %.2f\n",ss);
	
	return 0; 
}
 
