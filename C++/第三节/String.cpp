#include <iostream>
//利用String类型输入输出一个字符串 

int main(void){
	//字符串类型 
	std::string str; 
	std::cout << "请输入一串字符串：";
	//cin 直接将空格识别为结束符号；
	//std::cin >> str; 
	//所以这里采用getline 
	std::getline(std::cin,str);
	std::cout << str << std::endl;
	return 0;
}
