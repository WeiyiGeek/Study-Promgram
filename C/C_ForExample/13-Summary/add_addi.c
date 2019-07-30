#include <stdio.h>

int main(){
	int i,j;
	int a,b;
	i = 2;  //必须是变量不能是常亮.
	j = i++;  //i=i+1 , j = i      直接将i赋值给j；
	printf("i=%d,j=%d\n",i,j);  //如果是i--,1,2
	
	a = 2;
	b = ++a; //a=a+1 , b = 1 + a;  加一后在赋值给b；
	printf("a=%d,b=%d\n",a,b);  //如果是--a,1,1
	
	return 0;
}
