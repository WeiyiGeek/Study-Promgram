#include <iostream>

using namespace std;

void add(int a){
	static int num = 0;	 //静态变量  只会在程序结束时候销毁） 
	num += a;
	cout << "静态变量num的值为：" << num << endl;
}

int reduce(){
	static int count = 10; //在运行前编译中运行了一次（内存分配和初始化）,所以在程序运行中没有运行。 
	return count--;
}

int main(void){
	
	//不会每次都对num初始化 
	add(2);
	add(6);
	//不会每次都对count初始化  
	int b = 1; 
	for(;b<=10;b++){
		cout << b << " " << reduce() << endl;
	} 
	return 0;
} 

