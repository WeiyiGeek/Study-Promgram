#include <iostream>
#include <math.h>
#include <sstream>
/**
	一个参数求平方，两个参数求积，三个参数求和 
**/ 
using namespace std;

//函数重载 
void calc(double arg1);
void calc(double arg1,double arg2);
void calc(double arg1,double arg2,double arg3);


int main(int argc, char* argv[]){
	double arg1,arg2,arg3;
	if(argc == 2){ 
	    stringstream strtod(argv[1]);  //stringstream类 值得学习（将字符串转浮点数） 
		strtod >> arg1;
		strtod.clear(); //主动释放内存
		calc(arg1);
	}else if(argc == 3 ){
		stringstream strtod(argv[1]);
		strtod >> arg1;
		strtod.clear();  //主动释放内存
		stringstream sttod(argv[2]);
		sttod >> arg2;
		sttod.clear();  //主动释放内存
		calc(arg1,arg2);
	}else if(argc == 4 ){
		stringstream strtod(argv[1]);
		strtod >> arg1;
		strtod.clear();  //主动释放内存
		stringstream sttod(argv[2]);
		sttod >> arg2;
		sttod.clear();  //主动释放内存
		stringstream stod(argv[3]);
		stod >> arg3;
		stod.clear();  //主动释放内存
		calc(arg1,arg2,arg3);
	}else{
		cerr << "Usege: demo.exe arg1 [arg2 | arg3]" << endl; 
	}
	return 0;
} 

void calc(double arg1){
	cout <<  arg1 << " 平方值为 " << pow(arg1,2) << endl;   
	cout << "请输入任意字符退出！" << endl; 
	cin.get();
}

void calc(double arg1,double arg2){
	cout <<  arg1 << " 与 " << arg2  << " 积为 " << arg1*arg2 << endl;   
	cout << "请输入任意字符退出！" << endl; 
	cin.get();
}

void calc(double arg1, double arg2, double arg3){
	cout <<  arg1 << " + " << arg2 << " + " << arg3 << " = " << arg1+arg2+arg3 << endl;   
	cout << "请输入任意字符退出！" << endl; 
	cin.get();
}

