#include <iostream>
/** C++ �麯�� ������ʹ�� **/

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
	void play(){
		std::cout << name << "������ˣ - Have Play! \n"; 
	} 
}; 
class Dog:public Pet{
public:
	Dog(std::string xm);
	//�뷨��Ϊ�� ���� ����ķ��� 
	void eat(){
		std::cout << name << "���ڳԹ�ͷ���� - Have Dinner��\n"; 
	}
	void sleep(){
		std::cout << name << "�����Ľų����˯�� - Have Sleep��\n"; 
	} 
	void play(){
		std::cout << name << "���ں��������� - Have Play! \n"; 
	} 
};
 
class Cat:public Pet{
public:
	Cat(std::string xm); 
	void eat(){ 
		std::cout << name << "���ڳ�С��� - Have Dinner��\n"; 
	}
	void sleep(){
		std::cout << name << "�������ŵ�˯�� - Have Sleep��\n"; 
	} 
	void play(){
		Pet::play(); 
		std::cout << name << "������ë���� - Have Play! \n"; 
	}
}; 

//���๹���� 
Dog::Dog(std::string xm):Pet(xm){	
}
Cat::Cat(std::string xm):Pet(xm){
} 


int main(void){
	//�������ʵ����ʹ�� ��û�κ�����ģ��������ĸ��Ǹ���ķ����� 
	Dog gg("����");
	gg.eat();
	gg.sleep();
	gg.play();
	
	std::cout << "\n\n";
	 
	//��ʹ��new�ؼ�����newһ����Ķ���ʱ�򣬽��������벻��������
	Pet *cat = new Cat("�ӷ�è");
	//��������ʹ�õ���ָ����ʹ�� -> ��Ա/���� 
	cat -> eat();  //����ѡ���˻�������ķ�������������������ĸ��Ƿ��� 
	cat -> sleep();
	cat -> play();
	delete cat; //һ��Ҫ��סʹ�ú�ɾ���ڴ��

	return 0;	
} 
