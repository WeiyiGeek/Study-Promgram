#include <iostream>

//基类 - 代入参数
class Base {
public:
    Base(std::string tname);
    std::string name;
    void action();
};
//子类 继承 基类
class Sub:public Base {
public:
    Sub(std::string tname);
    void info(); 
};

//析构器的定义
Base::Base(std::string tname){
    name = tname;
    std::cout << " 进入 基类 构造器 -- \n";
}
//注意子类析构器的不同,当基类与子类拥有相同的方法参数时候，如下
Sub::Sub(std::string tname):Base(tname){
	std::cout << " 进入 子类 构造器 -- \n";
}

//方法
void Base::action(){
 	std::cout << " 基类的方法 --- \n\n"; 
 }
void Sub::info(){
	std::cout << "姓名：" << name; 
} 

int main(void){
	
	Sub demo("WeiyiGeek"); 
	demo.action();
	demo.info();
	
	std::cout << std::endl;
	return 0;
}
