#include <stdio.h>
#include <math.h>
int main(){
	int i,money=10000;
	float xjy,hy;
	for(i=1;i>0;i++){
		
		xjy=money+(money*0.1)*i;
		hy=money*pow((1+0.05),i);	
		if(hy > xjy){
			printf("%d��󣬺�ҹ��Ͷ�ʶ��С���㣡\n",i);
			printf("С����Ͷ�ʶ%.2f\n",xjy);
			printf("��ҹ��Ͷ�ʶ�: %.2f\n",hy);
			break;
		} 
		
	}
	return 0;
} 
