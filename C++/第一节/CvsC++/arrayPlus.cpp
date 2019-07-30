#include <iostream>
/**利用C++进行完成数组累加**/ 
using namespace std;
int arrayAdd(int *array,int length);  

int main(void){
	
	int array[] = {1,2,3,4,5,6,7,8,9,0};  //占用40字节 
	int len = sizeof(array) / sizeof(array[0]); //取数组个数 
	cout << "C++语法:数组 0..9 之和为=" << arrayAdd(array,len) << endl; 
	return 0;
} 

int arrayAdd(int *array,int length){
	int sum = 0,i = 0;
	for(; i < length; i++){
		sum += *array++;  //array只占用4字节(即一个指针) 
	}
	return sum; 
}

