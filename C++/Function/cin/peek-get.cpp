#include <iostream> 
using namespace std;
int main(void){
	char ch;
	cout << "请输入字符串:";
	// >> cin 输入操作符（提取操作），他一次从输入流对象提取一个整数
	// 当用户进行键盘输入时候,先将字符输入到操作系统键盘缓冲区中,按enter才把他们传入cin流内部缓冲区，>> 则从这个缓冲区提取字符 
	
	while(cin.peek() != '\n'){
		//输出到控制台 
		cout << (ch = cin.get());
	} 
	
	cout << endl; 
	return 0;
}
