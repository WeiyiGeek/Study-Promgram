#include <iostream>
/**��������**/
using namespace std;
//������������
union mima {
    unsigned long birthday;
    unsigned short ssn;
    char* pet;
} pass; //ע��ֺ�

int main(void){
	//���������Ա��ֵ 
	pass.birthday = 20170101;
	cout << "�������룺" << pass.birthday << endl;
	//���ַ�����ֵ��pass������pet��Ա ����ʱ���ᶪ��birthday��Ա��ֵ�� 
	pass.pet = "DOG-pig";
	cout << "���ճ��" << pass.pet << endl;	 
	cout << "���ʵ����pass.petֵ��" << (char*)pass.birthday << endl;
	cout << "pass.birthday���ʵ����pass.pet��ַ��" << pass.birthday << endl;
	return 0;
} 

