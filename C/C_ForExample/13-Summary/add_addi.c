#include <stdio.h>

int main(){
	int i,j;
	int a,b;
	i = 2;  //�����Ǳ��������ǳ���.
	j = i++;  //i=i+1 , j = i      ֱ�ӽ�i��ֵ��j��
	printf("i=%d,j=%d\n",i,j);  //�����i--,1,2
	
	a = 2;
	b = ++a; //a=a+1 , b = 1 + a;  ��һ���ڸ�ֵ��b��
	printf("a=%d,b=%d\n",a,b);  //�����--a,1,1
	
	return 0;
}
