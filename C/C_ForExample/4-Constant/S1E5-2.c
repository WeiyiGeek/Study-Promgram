#include <stdio.h>

#define FQ 3.7
#define XQ 1.3
#define KXC 8
#define YC 2.4 
#define YOUCAI 9
#define HG 6.3
#define BLB 0.5
  
int main(){
	float price;
	
	price = (2 * FQ + KXC + YOUCAI) * 0.5;  // 1 �� = 0.5 ǧ�� 
	printf("С����Ҫ֧��%.2fԪ\n",price);
	
	price = (3 * XQ + 0.5 * YC + 5 * HG)*0.5;
	printf("С����Ҫ֧��%.2fԪ\n",price);
	
	price = (10 * HG + 20 *BLB)*0.5;
	printf("С������Ҫ֧��%.2fԪ\n",price);
	
	return 0;
	
}
