#include <iostream>
/**C++ ֮ ��֤��̬�������ܵ��÷Ǿ�̬������ */
class Base {
public:
	std::string name;
	int sex; 
	static int num;	
	//������������������壨Ҳ�ǿ��Եģ� 
	Base(std::string na,int sex){
		name = na;
		this->sex = sex; 
		std::cout << "�ҵ����֣�" << name << " this ��ַ��"  << this << std::endl; 
	} 
	static void method(){
		std::cout << "��̬�������þ�̬���ԣ�" <<Base::num << "\n"; 
		//std::cout << "��̬�������÷Ǿ�̬���ԣ�" << name << "\n";  //�ᱨ��  [����]�ھ�̬��Ա�����е����Ƶ��÷Ǿ�̬��Ա
		//std::cout << this->name << " this ��ַ��" << this->num << "\n";  //�����ھ�̬��Ա������ʹ�� this ָ�루��Ϊ�������ᴫ����� 
	} 
	void vitry(){
		std::cout <<  "���е�1��name��Ա��ַ��" << &this->name << " --- " << this->name << "\n";
		std::cout <<  "���е�2��sex��Ա��ַ��" << &this->sex << " --- " <<this->sex << "\n";
	}
};

//��ʼ����̬����
int Base::num = 1024; 

int main(void){
	//ʵ��������
	
	Base myName("�ž�",1); 
	Base::method();  //### ע�⣺���þ�̬����ʱ����û�����֮����ü��� 
	myName.method();  //��Ȼ��������Ҳ����,���ǲ�����ʹ�ö����������þ�̬��Ա���� 
	std::cout << "\n"; 
	std::cout << "����ĵ�ַ��" <<  &myName << std::endl; 
	myName.vitry();  //��������this��ַ�����ĵ�ַ��ͬ ���ҵ�ַ�����е�һ����Ա���߷�����ַ��ͬ|����������ĵ�ַһ���� 
	
	return 0;
}
