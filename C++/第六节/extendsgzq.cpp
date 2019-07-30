#include <iostream>

//���� - �������
class Base {
public:
    Base(std::string tname);
    std::string name;
    void action();
};
//���� �̳� ����
class Sub:public Base {
public:
    Sub(std::string tname);
    void info(); 
};

//�������Ķ���
Base::Base(std::string tname){
    name = tname;
    std::cout << " ���� ���� ������ -- \n";
}
//ע�������������Ĳ�ͬ,������������ӵ����ͬ�ķ�������ʱ������
Sub::Sub(std::string tname):Base(tname){
	std::cout << " ���� ���� ������ -- \n";
}

//����
void Base::action(){
 	std::cout << " ����ķ��� --- \n\n"; 
 }
void Sub::info(){
	std::cout << "������" << name; 
} 

int main(void){
	
	Sub demo("WeiyiGeek"); 
	demo.action();
	demo.info();
	
	std::cout << std::endl;
	return 0;
}
