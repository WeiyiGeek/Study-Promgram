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
	
	printf("应该给予%llu粒麦子\n",sum);   //注意这里的是%llu，long long 长度进行输出 
	printf("应该给予%llu斤麦子\n",weight);

	return 0;	
}


    
