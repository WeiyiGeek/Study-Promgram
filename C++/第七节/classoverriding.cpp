#include <iostream>
/** 实现C++重写[覆盖]demo**/

class Car {
public:
	void info(std::string xz); 
};

class Small:public Car{
public:
	//重写基类中的方法 
	void info(std::string xz);	
};

//定义的方法：！！！注意方法类型！！！！！ 
void Car::info(std::string xz){
	std::cout << "基类info方法：" << xz << "\n"; 
} 
void Small::info(std::string xz){
	std::cout << "子类覆盖info方法：" << xz << "\n"; 
}

int main(void){
	
	Car demo1;
	demo1.info("Car"); 
	Small demo;
	demo.info("Small");
	
	return 0;
} 
