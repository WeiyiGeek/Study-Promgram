#include <iostream>
#include <math.h>
#include <sstream>
/**
	һ��������ƽ���������������������������� 
**/ 
using namespace std;

//�������� 
void calc(double arg1);
void calc(double arg1,double arg2);
void calc(double arg1,double arg2,double arg3);


int main(int argc, char* argv[]){
	double arg1,arg2,arg3;
	if(argc == 2){ 
	    stringstream strtod(argv[1]);  //stringstream�� ֵ��ѧϰ�����ַ���ת�������� 
		strtod >> arg1;
		strtod.clear(); //�����ͷ��ڴ�
		calc(arg1);
	}else if(argc == 3 ){
		stringstream strtod(argv[1]);
		strtod >> arg1;
		strtod.clear();  //�����ͷ��ڴ�
		stringstream sttod(argv[2]);
		sttod >> arg2;
		sttod.clear();  //�����ͷ��ڴ�
		calc(arg1,arg2);
	}else if(argc == 4 ){
		stringstream strtod(argv[1]);
		strtod >> arg1;
		strtod.clear();  //�����ͷ��ڴ�
		stringstream sttod(argv[2]);
		sttod >> arg2;
		sttod.clear();  //�����ͷ��ڴ�
		stringstream stod(argv[3]);
		stod >> arg3;
		stod.clear();  //�����ͷ��ڴ�
		calc(arg1,arg2,arg3);
	}else{
		cerr << "Usege: demo.exe arg1 [arg2 | arg3]" << endl; 
	}
	return 0;
} 

void calc(double arg1){
	cout <<  arg1 << " ƽ��ֵΪ " << pow(arg1,2) << endl;   
	cout << "�����������ַ��˳���" << endl; 
	cin.get();
}

void calc(double arg1,double arg2){
	cout <<  arg1 << " �� " << arg2  << " ��Ϊ " << arg1*arg2 << endl;   
	cout << "�����������ַ��˳���" << endl; 
	cin.get();
}

void calc(double arg1, double arg2, double arg3){
	cout <<  arg1 << " + " << arg2 << " + " << arg3 << " = " << arg1+arg2+arg3 << endl;   
	cout << "�����������ַ��˳���" << endl; 
	cin.get();
}

