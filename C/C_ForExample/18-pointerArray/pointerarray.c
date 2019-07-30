#include <stdio.h>

int main(){
	char *p1[5] = {  //定义一个指针数组 
		"编程改变世界",
		"Just do it --- NIKE",
		"一切皆有可能",
		"永不止步",
		"one more thing" 
	};
	
	int i;
	
	for(i = 0;i < 5;i++){
		printf("%s\n", p1[i]);	 //坑，注意这里没有取值运算符*，由于指针数组本身就取下标为0的字符串 
	}
	return 0;
} 

