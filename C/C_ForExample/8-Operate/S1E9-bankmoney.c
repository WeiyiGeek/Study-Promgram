#include <stdio.h>
#include <math.h>

int main(){
	
	float p1,p2,p3;
	float money=10000,r1=0.0175,r2=0.0225,r3=0.0275,r5=0.0275;
	
	p1 = money * (1 + r5 * 5);
	printf("���궨�ڴ�����Ϣ:%.2f\n",p1);
	
	p2 = money * (1 + r3 * 3) * (1 + r2 * 2);  
	printf("�ȴ�3�꣬��Ϣ�ڴ�2�����Ϣ:%.2f\n",p2);
	
	p3 = money * pow(1+r1,5);
	printf("��5��һ�����Ϣ��%.2f\n",p3);
	
	return 0; 
}


