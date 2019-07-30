#include <stdio.h>
#include <math.h>
int main(){
	int i,money=10000;
	float xjy,hy;
	for(i=1;i>0;i++){
		
		xjy=money+(money*0.1)*i;
		hy=money*pow((1+0.05),i);	
		if(hy > xjy){
			printf("%d年后，黑夜的投资额超过小甲鱼！\n",i);
			printf("小甲鱼投资额：%.2f\n",xjy);
			printf("黑夜的投资额: %.2f\n",hy);
			break;
		} 
		
	}
	return 0;
} 
