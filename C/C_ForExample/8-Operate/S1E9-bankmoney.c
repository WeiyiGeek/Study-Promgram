#include <stdio.h>
#include <math.h>

int main(){
	
	float p1,p2,p3;
	float money=10000,r1=0.0175,r2=0.0225,r3=0.0275,r5=0.0275;
	
	p1 = money * (1 + r5 * 5);
	printf("五年定期存款的利息:%.2f\n",p1);
	
	p2 = money * (1 + r3 * 3) * (1 + r2 * 2);  
	printf("先存3年，本息在存2年的利息:%.2f\n",p2);
	
	p3 = money * pow(1+r1,5);
	printf("存5次一年的利息：%.2f\n",p3);
	
	return 0; 
}


