#include <stdio.h>
int main(){
	int a = 3, b =3;
	(a = 0) && (b = 5);  //逻辑与,一假必假，所以a=0的时候就判断出来了，就不对第二个操作数进行判断了
	printf("a = %d,b = %d\n",a,b); 
	
	(a = 1) || (b = 5);  //逻辑或,一真必真，所以也是判断第一个操作数就可以判断处真假从而不进行第二个操作数的逻辑判断
	printf("a = %d,b = %d\n",a,b);
	return 0;
}