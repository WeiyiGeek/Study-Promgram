#include <stdio.h>

int main(){
	int a = 1;
	int b = 2;
	int c = 3;
	int d = 4;
	int e = 5;  
	int *p1[5] = {&a,&b,&c,&d,&e}; //定义一个指针数组,取地址 
	
	int i;
	
	for(i = 0;i < 5;i++){
		printf("%d\n",*p1[i]);	 //坑，注意这里有取值运算符*，由于上面是引入的是变量地址，所以这里需要取值运算符 
	}
	return 0;
} 

