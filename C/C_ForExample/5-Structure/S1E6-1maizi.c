#include <stdio.h>
#include <math.h>

int main(){
	
	unsigned long long sum=0;
	unsigned long long temp;
	unsigned long long weight;
	int a;
	
	for(a=0; a < 64; a++){
		temp = pow(2, a);
		sum = temp + sum;
	}
	
	weight = sum / 25000;
	
	printf("Ӧ�ø���%llu������\n",sum);   //ע���������%llu��long long ���Ƚ������ 
	printf("Ӧ�ø���%llu������\n",weight);

	return 0;	
}


    
