#include <iostream>
/** ʵ��C++��д[����]demo**/

class Car {
public:
	void info(std::string xz); 
};

class Small:public Car{
public:
	//��д�����еķ��� 
	void info(std::string xz);	
};

//����ķ�����������ע�ⷽ�����ͣ��������� 
void Car::info(std::string xz){
	std::cout << "����info������" << xz << "\n"; 
} 
void Small::info(std::string xz){
	std::cout << "���า��info������" << xz << "\n"; 
}

int main(void){
	
	Car demo1;
	demo1.info("Car"); 
	Small demo;
	demo.info("Small");
	
	return 0;
} 
