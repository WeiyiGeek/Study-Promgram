#include <stdio.h>
/**C语言实现数组累加(采用指针得形式)**/

int arrayAdd(int *array,int length); //为了规范化我们还是先声明后使用 

int main(void){
	
	int array[] = {1,2,3,4,5,6,7,8,9,0};  //占用40字节 
	int len = sizeof(array) / sizeof(array[0]); //取数组个数 
	printf("C语法:数组 0..9 之和为=%d\n",arrayAdd(array,len)); 
	return 0;
} 

int arrayAdd(int *array,int length){
	int sum = 0,i = 0;
	for(; i < length; i++){
		sum += *array++;  //array只占用4字节(即一个指针) 
	}
	return sum; 
}
