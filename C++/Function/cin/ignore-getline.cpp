#include <iostream>

using namespace std;

int main(void){
	char buf[20];
	cin.ignore(7);  //忽略输入流中的字符 
	cin.getline(buf,10); //获取输入流字符到buf数组中 
	cout << buf << endl;
	return 0;
} 
