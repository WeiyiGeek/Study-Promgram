#include <iostream>

using namespace std;

int main(void){
	char buf[20];
	cin.ignore(7);  //�����������е��ַ� 
	cin.getline(buf,10); //��ȡ�������ַ���buf������ 
	cout << buf << endl;
	return 0;
} 
