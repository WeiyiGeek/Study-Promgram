#include <iostream>
#include <sstream>
#include <ctime>

const int NUM = 65535;

using namespace std;

void stringClear(void);
void sprintfTime(void);

int main(void){
	stringClear(); //stringstream 类耗时 
	sprintfTime();  //sprintf 函数耗时 
	return 0;
}

void stringClear(void){
	double t_start = (double)clock();  //需要加入 <ctime>
	stringstream sstr;
	for(int i = 0; i < NUM; i++ ){
		sstr << i;
		sstr.str();
		sstr.clear(); //清理内存 
	}
	double t_end = (double)clock();
	cout << "stringstream Time : " <<t_end - t_start << endl; 
}

void sprintfTime(void){
	double t_start = (double)clock();
	char *pstr = new char[50];
	for(int i = 0; i < NUM; i++ ){
		sprintf(pstr,"%d",i);
	}
	double t_end = (double)clock();
	cout << "sprintf function Time : " <<t_end - t_start << endl; 
}


