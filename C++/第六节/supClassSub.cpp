#include <iostream>
/** ���� - ���� demo ��ʾ **/

//�������ࣨ���ࣩ 
class Animal 
{
public:
	std::string animalName;
	char sex;
	void eat();
	void sleep();
};

//�������� 
class Turtle:public Animal
{
public:
	void info(); 
}; 

class Pig:public Animal
{
public:
	void info(); 
}; 

//���巽�� (��Ҫ�����ڷ�����ǰ����� ����::)
void Animal::eat(){
	std::cout << this->animalName <<"���ڽ�ʳ��" << std::endl; 
} 

void Animal::sleep(){
	std::cout << this->animalName <<"������Ϣ��" << std::endl; 
}

//���෽��
void Turtle::info(){
 	std::string xb;
	xb =  (this->sex == 'F')?"����":"����"; 
	std::cout << "�������ƣ�" << this->animalName <<" �����Ա�" << xb << std::endl;
 }

void Pig::info(){
 	std::string xb;
	xb = (this->sex == 'F')?"����":"����"; 
	std::cout << "�������ƣ�" << this->animalName <<" �����Ա�" << xb << std::endl;
 }

int main(void){
	
	Turtle wg;
	wg.animalName = "С����";
	wg.sex = 'F';
	wg.info();
	wg.eat();
	
	std::cout << std::endl;
	
	Pig zz;
	zz.animalName = "С����";
	zz.sex = 'M';
	zz.info();
	zz.sleep();
	
	return 0;
}
