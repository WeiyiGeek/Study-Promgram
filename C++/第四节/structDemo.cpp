#include <iostream>
/**
	C++ �ṹ�� Demo 
**/
using namespace std;
 
int main(void){
	
	//�ṹ��������һ������ĸ��д 
	struct Demo {
		string name;
		int uid;
		char sex;		 
	};
	//ʹ�ýṹ�巽ʽ 1
	Demo study = {"��ΰ",20180101,'F'};
	cout << "������" << study.name << "\nѧ�ţ�" << study.uid << "\n�Ա�" << study.sex << endl;
	
	 //ʹ�ýṹ�巽ʽ 1
	Demo study1;
	study1.name = "��β"; 
	study1.uid = 20180102;
	study1.sex = 'M';
	cout << "\n������" << study1.name << "\nѧ�ţ�" << study1.uid << "\n�Ա�" << study1.sex << endl;

	
	
	return 0;
}

