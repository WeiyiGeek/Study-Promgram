#include <stdio.h>
#include <math.h>
//字符型 整型的数据长度 

int main(){
	unsigned char b;
	int unsc;
	unsc = pow(2,sizeof(b)*8) -1;
	printf("signed char length = -%d ~ %d\n",unsc/2+1,unsc/2);
	printf("unsigned char length = 0 ~ %d\n\n",unsc);

	unsigned short int a;
	int unsi;
	unsi = pow(2,sizeof(a)*8) -1;
	printf("signed short int length = -%d ~ %d\n",unsi/2+1,unsi/2);
	printf("unsigned short int length = 0 ~ %d\n\n",unsi);

	unsigned int c;
	c = pow(2,sizeof(c)*8) -1;
	printf("signed int length = -%u ~ %u\n",c/2+1,c/2);
	printf("unsigned int length = 0 ~ %u\n\n",c);
	
	unsigned long int d;
	d = pow(2,sizeof(d)*8) -1;
	printf("signed long int length = -%lu ~ %lu\n",d/2+1,d/2);
	printf("unsigned long int length = 0 ~ %lu\n\n",d);

	unsigned long long int e;
	e = (unsigned long long int)(pow(2,sizeof(e)*8) -1);  //进行强制转换就不会报出overflow 
	printf("signed long int length = -%llu ~ %llu\n",e/2+1,e/2,sizeof(e));
	printf("unsigned long int length = 0 ~ %llu\n\n",e);
	
	return 0;
}
