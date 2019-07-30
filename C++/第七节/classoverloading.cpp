#include <iostream>
/**实现c++类里面的重载案例**/
class Base{
public:
	void init();
	void init(std::string zz);	
};

class Subf:public Base{
public:
	std::string sub;
	//void init(std::string name,char sex);  //子类重载（Error）		
};
class Subs:public Base{
public:
	std::string sub;
}; 

//定义方法 
void Base::init()
{
	std::cout << "初始化程序 ...... \n";
}
//基类重载的方法
void Base::init(std::string zz){
	std::cout << "基类-重载初始化程序......" << zz << "\n";
} 

/** 子类中重载基类方法会报错 
void Subf::init(std::string name,char sex){
	sub = name 
	std::cout << "子类-重载初始化程序 --->>> " << sub << "\n"; 
}**/
 
int main(void){
	Subf demo;
	demo.init();
	demo.init("demo对象重载\n");
	//在子类中重载基类的方法会报错 
	//demo.init("Weiyigeek",'F');
	
	Subs demo1;
	demo1.init();
	demo1.init("demo1对象重载");

	return 0;
} 

