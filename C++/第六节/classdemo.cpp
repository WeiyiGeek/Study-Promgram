#include <iostream>
/**
	Class ���� Object�����ʼ��֤ 
**/ 

//������ 
class Person{
	public:
		//�������� 
		std::string name;
		//��������ԭ�� 
		void cook(void);
};

//�����������ж��巽��
void Person::cook(void){
	std::cout << "�����������Һܺóԣ�" << std::endl;
} 


int main(void){
	//ʵ���� -> ���� 
	Person girl; 
	//�������Ը�ֵ 
	girl.name = "С��������";
	std::cout << "Name : " << girl.name << std::endl;
	//���󷽷����� 
	girl.cook(); 
	return 0;
}
