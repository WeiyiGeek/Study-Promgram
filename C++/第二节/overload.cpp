#include <iostream>
/**
	华摄温度  F = 摄氏温度 C 的相互转换
	F =  C * 9.0 / 5.0 + 32；
	利用C++重载的方式 
**/

//声明重载函数 
void convertTemparature(double tempIn,char typeIn);
void convertTemparature(int tempIn, char typeIn) ;

int main(void){
	
	//定义输入为浮点数和整型接收值的变量 
	double tempIn;
	int tempInInt;
	char  typeIn; //存放输入的单位
	
	std::cout << "请输入xxx.XX F 或者 ooo.oo C的格式进行华氏温度与摄氏温度相互转换："; 
	std::cin >> tempIn >> typeIn;
	std::cin.ignore(100,'\n'); //忽略回车 
	std::cout << std::endl;
	convertTemparature(tempIn,typeIn);
	
	std::cout << "请输入xxx F 或者 ooo C的格式进行华氏温度与摄氏温度相互转换："; 
	std::cin >> tempInInt >> typeIn;
	std::cin.ignore(100,'\n'); //忽略回车 
	std::cout << std::endl;
	convertTemparature(tempInInt,typeIn);

}

//参数为浮点数 
void convertTemparature(double tempIn , char typeIn){
	//在C++定义常量建议使用const 
	const unsigned short NUM = 32;
	const double RATIO = 9.0 / 5.0;
	
	double tempOut; 
	char typeOut;
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
		return;
	}
	std::cout << "请输入任何符号结束程序!" << std::endl; 
	std::cin.get();
}

//参数为整型
void convertTemparature(int tempIn , char typeIn){
	//在C++定义常量建议使用const 
	const unsigned short NUM = 32;
	const double RATIO = 9.0 / 5.0;
	int tempOut; 
	char typeOut;
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
		return;
	}
	std::cout << "请输入任何符号结束程序!" << std::endl; 
	std::cin.get();
}
