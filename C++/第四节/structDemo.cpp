#include <iostream>
/**
	C++ 结构体 Demo 
**/
using namespace std;
 
int main(void){
	
	//结构体类型名一般首字母大写 
	struct Demo {
		string name;
		int uid;
		char sex;		 
	};
	//使用结构体方式 1
	Demo study = {"张伟",20180101,'F'};
	cout << "姓名：" << study.name << "\n学号：" << study.uid << "\n性别：" << study.sex << endl;
	
	 //使用结构体方式 1
	Demo study1;
	study1.name = "结尾"; 
	study1.uid = 20180102;
	study1.sex = 'M';
	cout << "\n姓名：" << study1.name << "\n学号：" << study1.uid << "\n性别：" << study1.sex << endl;

	
	
	return 0;
}

