#include <iostream>
/**
	Class 类与 Object对象初始验证 
**/ 

//声明类 
class Person{
	public:
		//声明属性 
		std::string name;
		//声明方法原型 
		void cook(void);
};

//在声明类后进行定义方法
void Person::cook(void){
	std::cout << "会做饭，而且很好吃！" << std::endl;
} 


int main(void){
	//实例化 -> 对象 
	Person girl; 
	//对象属性赋值 
	girl.name = "小泽玛利亚";
	std::cout << "Name : " << girl.name << std::endl;
	//对象方法调用 
	girl.cook(); 
	return 0;
}
