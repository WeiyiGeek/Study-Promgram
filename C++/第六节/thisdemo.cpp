#include <iostream>
/**  This指针的使用demo **/ 

class Human{
public: 
	std::string name;
	unsigned short age;
	char sex;
	Human(std::string na, unsigned short ag, char sex);  //构造器 
};

Human::Human(std::string na, unsigned short ag, char sex){
	name = na;
	age = ag;
	this->sex = sex;
} 


int main(void){
	//在实例化时候进行对象的 初始化 
	Human demo("Weiyi",23,'F');
	std::string sex;
	sex = (demo.sex == 'F') ? "女":"男"; 
	std::cout << "姓名：" << demo.name
			  << "  年龄：" << demo.age
			  << "  性别：" << sex << std::endl; 
	return 0; 
}; 
