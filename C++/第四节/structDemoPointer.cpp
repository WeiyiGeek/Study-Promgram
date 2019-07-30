#include <iostream>
#include <fstream>
/**
	利用结构体指针实现学生成绩的
	1.读取到终端
	2.写入到文件
	3.录入信息 
**/ 

using namespace std;
//结构体类型名一般首字母大写 
struct Demo {
		string name;
		int uid;
		char sex;		 
} studyy;

bool Init(void);
bool Read(void);
bool Write(Demo *stuData);

int main(void){
	if(Init()){
		cerr  << "初始化程序失败!!!" << endl;
		return 1; 
	}
	int xh;
	while(1){
		cout << "请选择学生信息管理系统功能：\n (1)读取学生信息 \n (2)写入学生信息 \n (3)退出程序 " << endl; 
		cout << "输入的序号："; 
		cin >> xh;
		cout << endl;
		
		switch(xh){	
			case 1:
				if(Read()){
					cerr << "读取失败！！！" << endl; 
				}
				break;
			case 2:
				
				cout << "输入姓名：";
				cin >> studyy.name;
				cout << "输入学号：";
				cin >> studyy.uid;
				cout << "输入性别："; 
				cin >> studyy.sex;			 
				Write(&studyy);
				break;
			case 3:
				cout << " <<--已退出程序-->> " << endl; 
				return 1;
			default:
				cerr << " 输入有误请重新输入序号<1,2,3> " << endl; 
		}
		cout << "\n" << endl; 
	} 
	
	return 0; 
} 

//初始化程序
bool Init(void){
	//写入的文件 
	ofstream out("test.txt"); 
	//当返回0时候打开失败
	if(!out){
        //标准错误流
		cerr << "Open Fail!!\n" << endl;
		return 1; 
	} 
	
	Demo study = {"Weiyi",20180101,'f'};
	out << study.name << " " << study.uid << " " << study.sex << "\r\n" << endl;
	out.close();
	return 0; 
} 

//读取程序 
bool Read(void){
	ifstream in("test.txt");
	if(!in){
		 //标准错误流
		cerr << "Open Fail!!\n" << endl;
		return 1; 
	}
	
	string info;
	int i=1;
	while(in >> info){
		cout << info << " "; 
		if(i % 3 == 0){
			cout << "\n";
		}
		i++;
	}
	cout << endl;
	in.close();
	return 0;
}

//利用指针写入 
bool Write(Demo *stuData){
//写入的文件 
	ofstream out("test.txt",ios::app); 
	//当返回0时候打开失败
	if(!out){
        //标准错误流
		cerr << "Open Fail!!\n" << endl;
		return 1; 
	} 

	out << stuData->name << " " <<stuData->uid << " " << stuData->sex << "\r\n" << endl;
	out.close();
	
	return 0; 

}
