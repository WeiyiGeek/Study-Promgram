#include <iostream>
/** C++ new ���� => ����ʹ���麯�� ���и��ǻ����еķ���  **/

class Pet{
public:
	std::string name;
	//���๹�������� 
	Pet(std::string xm){
		name = xm;
		std::cout << "������ʼ����" << name << "\n";
	}
	void eat(){
		std::cout << name << "���ڳԷ� - Have Dinner��\n"; 
	} 
	void sleep(){
		std::cout << name << "����˯�� - Have Sleep��\n"; 
	} 
	//��������Ϊ�鷽�� 
	virtual	void play(){
		std::cout << name << "������ˣ - Have Play! \n"; 
	} 
}; 
 
class Cat:public Pet{
public:
	Cat(std::string xm); 
	void eat(){ 
		std::cout << name << "���ڳ�С��� - Have Dinner��\n"; 
	}
	void sleep(){
		Pet::sleep(); //���ڲ����鷽����������sleep()�޷����� �����sleep()���� ���������佫����ִ�У� 
		std::cout << name << "�������ŵ�˯�� - Have Sleep��\n"; 
	} 
	void play(){
		//Pet::play(); �������鷽������������������ͬʱҲ������������䣩 
		std::cout << name << "������ë���� - Have Play! \n"; 
	}
}; 

//���๹���� 
Cat::Cat(std::string xm):Pet(xm){
} 


int main(void){
	//����һ��Pet���͵�catָ����� ��� ����һ��new��������ĵ�ַ; ��ָ�뼰��ַ�� 
	Pet *cat = new Cat("�ӷ�è");
	//��������ʹ�õ���ָ����ʹ�� -> ��Ա/���� 
	cat -> eat();  
	cat -> sleep();
	cat -> play();
	delete cat; //һ��Ҫ��סʹ�ú�ɾ���ڴ��
	return 0;	
} 
