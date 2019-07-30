#include <iostream>
/**
	华摄温度  F = 摄氏温度 C 的相互转换
	F =  C * 9.0 / 5.0 + 32；
	华摄温度就是逆运算； 
**/

int main(void){
	//在C++定义常量建议使用const 
	const unsigned short NUM = 32;
	const double RATIO = 9.0 / 5.0;
	
	double tempIn,tempOut; //存放输入的数值 
	char  typeIn,typeOut; //存放输入的单位
	
	std::cout << "请输入xxx.XX F 或者 ooo.oo C的格式进行华氏温度与摄氏温度相互转换："; 
	std::cin >> tempIn >> typeIn;
	std::cin.ignore(100,'\n'); //忽略回车 
	std::cout << std::endl;
	 
	switch(typeIn){
		case 'f':
		case 'F':
			tempOut =  (tempIn - NUM) * (1.0 / RATIO); 
			typeIn = 'F';
			typeOut = 'C';
			break;
			
		case 'c':
		case 'C':
			tempOut =  tempIn * RATIO + NUM; 
			typeIn = 'C';
			typeOut = 'F';
			break;
		default:
			typeOut = 'E';
			std::cout << "Dear.输入格式有误！" << std::endl; 
	} 
	
	//为了程序的健壮性，必须将用户输入的 
	if(typeOut != 'E'){
		std::cout << "输出计算结果为：\n" << tempIn << typeIn << " = " << tempOut << typeOut << std::endl;
	}else{
		return 1;
	}
	std::cout << "请输入任何符号结束程序!" << std::endl; 
	std::cin.get();
	
	return 0; 
}
