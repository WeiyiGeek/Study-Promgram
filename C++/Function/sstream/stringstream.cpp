#include <iostream> 
#include <sstream>
#include <cstring>

//�ַ��� stringstream 
using namespace std;

int main(void){
	//�ַ��������� 
	char test[] = "123";
	int num;
	stringstream ab(test);
	ab >> num;
	cout << "������֮�� " << num + num << endl;
	 
	//���͵��ַ���
	float x = 10.24 ;
	stringstream sstr;
	sstr << x; 
    string str = sstr.str();   //string ��Ҫ���� <cstring> ͷ�ļ� 
    cout << "String Ϊ " << str << endl; 
	return 0;
}
