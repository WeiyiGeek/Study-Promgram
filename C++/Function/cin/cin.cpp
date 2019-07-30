#include <iostream>
using namespace std;
int main(void){
	int num,sum=0;
	cout << "请输入一个浮点数：";
	//当我们输入3.14 返回一个false ,这时sum 只会读取到 3  
	while(cin >> num){
		sum += num;
	}	
	cout << "Sum = " << sum << endl; 
	return 0;
}
