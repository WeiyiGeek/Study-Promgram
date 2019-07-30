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
	
	price = (2 * FQ + KXC + YOUCAI) * 0.5;  // 1 斤 = 0.5 千克 
	printf("小明需要支付%.2f元\n",price);
	
	price = (3 * XQ + 0.5 * YC + 5 * HG)*0.5;
	printf("小红需要支付%.2f元\n",price);
	
	price = (10 * HG + 20 *BLB)*0.5;
	printf("小甲鱼需要支付%.2f元\n",price);
	
	return 0;
	
}
