#include <iostream>

using namespace std;
void para(int age, int ageNext){
	age = ageNext;
	cout << "para 函数里面的年龄 ： " << age << endl; 
}

int main(void){
	int age = 22;
	cout << "初始化年龄 ： " << age << endl; 
	para(age,age+1);
	cout << "main 函数里面的年龄 ： " << age << endl; 
	
	return 0;
}
