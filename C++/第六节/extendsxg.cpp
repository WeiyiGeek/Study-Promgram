#include <iostream>
/**�̳��еĻ����븸���еĹ����� �� ������**/

//1.�� 
class Base{
	public:
		Base();
		~Base();
		void action(); 
};
//�̳� 
class Sub:public Base{
	public:
		Sub();
		~Sub();
};

//2.��Ĺ�����
Base::Base(){
	std::cout << "1.���� ����� ��������\n";	
} 

Sub::Sub(){
	std::cout << "2.���� ����� ��������\n";	
} 

//3.�෽�� (ע�ⲻҪ���Ƿ�������)
void Base::action() {
	std::cout << "3.���� ����ķ����� ��һЩ���飡\n\n";
}

//4.��������� 
Base::~Base(){
	std::cout << "4.���� ����� ��������\n";	
}
Sub::~Sub(){
	std::cout << "5.���� ����� ��������\n";	
}

int main(void){
	
	Sub demo;
	demo.action(); 
	
	std::cout << "���й�����ϣ��չ�~\n" << std::endl; 
	return 0;
}
