#include <iostream>

using namespace std;
void para(int age, int ageNext){
	age = ageNext;
	cout << "para ������������� �� " << age << endl; 
}

int main(void){
	int age = 22;
	cout << "��ʼ������ �� " << age << endl; 
	para(age,age+1);
	cout << "main ������������� �� " << age << endl; 
	
	return 0;
}
