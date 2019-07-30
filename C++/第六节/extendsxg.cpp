#include <iostream>
/**继承中的基类与父类中的构造器 与 析构器**/

//1.类 
class Base{
	public:
		Base();
		~Base();
		void action(); 
};
//继承 
class Sub:public Base{
	public:
		Sub();
		~Sub();
};

//2.类的构造器
Base::Base(){
	std::cout << "1.进入 父类的 构造器！\n";	
} 

Sub::Sub(){
	std::cout << "2.进入 子类的 构造器！\n";	
} 

//3.类方法 (注意不要忘记方法类型)
void Base::action() {
	std::cout << "3.进行 父类的方法干 了一些事情！\n\n";
}

//4.类的析构器 
Base::~Base(){
	std::cout << "4.进入 父类的 析构器！\n";	
}
Sub::~Sub(){
	std::cout << "5.进入 子类的 析构器！\n";	
}

int main(void){
	
	Sub demo;
	demo.action(); 
	
	std::cout << "所有工作完毕，收工~\n" << std::endl; 
	return 0;
}
