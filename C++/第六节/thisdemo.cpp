#include <iostream>
/**  Thisָ���ʹ��demo **/ 

class Human{
public: 
	std::string name;
	unsigned short age;
	char sex;
	Human(std::string na, unsigned short ag, char sex);  //������ 
};

Human::Human(std::string na, unsigned short ag, char sex){
	name = na;
	age = ag;
	this->sex = sex;
} 


int main(void){
	//��ʵ����ʱ����ж���� ��ʼ�� 
	Human demo("Weiyi",23,'F');
	std::string sex;
	sex = (demo.sex == 'F') ? "Ů":"��"; 
	std::cout << "������" << demo.name
			  << "  ���䣺" << demo.age
			  << "  �Ա�" << sex << std::endl; 
	return 0; 
}; 
