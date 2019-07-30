#include <iostream>
/** 基类 - 子类 demo 演示 **/

//声明基类（父类） 
class Animal 
{
public:
	std::string animalName;
	char sex;
	void eat();
	void sleep();
};

//声明子类 
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

//定义方法 (不要忘记在方法名前面加上 类名::)
void Animal::eat(){
	std::cout << this->animalName <<"正在进食！" << std::endl; 
} 

void Animal::sleep(){
	std::cout << this->animalName <<"正在休息！" << std::endl; 
}

//子类方法
void Turtle::info(){
 	std::string xb;
	xb =  (this->sex == 'F')?"雌性":"雄性"; 
	std::cout << "动物名称：" << this->animalName <<" 动物性别：" << xb << std::endl;
 }

void Pig::info(){
 	std::string xb;
	xb = (this->sex == 'F')?"雌性":"雄性"; 
	std::cout << "动物名称：" << this->animalName <<" 动物性别：" << xb << std::endl;
 }

int main(void){
	
	Turtle wg;
	wg.animalName = "小甲鱼";
	wg.sex = 'F';
	wg.info();
	wg.eat();
	
	std::cout << std::endl;
	
	Pig zz;
	zz.animalName = "小猪猪";
	zz.sex = 'M';
	zz.info();
	zz.sleep();
	
	return 0;
}
