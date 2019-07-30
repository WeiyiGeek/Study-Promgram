#include <iostream> 
/*
cin.peek();
cin.get() 
*/
using namespace std;

int main(void){
	int sum = 0,i;
	cout << "请输入一串整数与任意数码的空格:";
	// >> cin 输入操作符（提取操作），他一次从输入流对象提取一个整数
	// 当用户进行键盘输入时候,先将字符输入到操作系统键盘缓冲区中,按enter才把他们传入cin流内部缓冲区，>> 则从这个缓冲区提取字符 
	while(cin >> i){
		sum += i;
		while(cin.peek() == ' '){
			cin.get();
		}
		if(cin.peek() == '\n'){
			break;
		} 
	}
	cout << "结果是：" << sum << endl; 
	return 0;
}
