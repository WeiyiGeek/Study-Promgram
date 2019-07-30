#include <iostream>
/**关键词修饰符 -  C++访问控制级别*/

class Base {
public:
	std::string shape;
	Base(std::string xz);
	void modity(std::string xz,std::string ys, short num); 
//保护 
protected:
	std::string color; 
//私有的
private:
	unsigned short count;
}; 

class Sub:protected Base {
public:
	Sub(std::string xz);	
}; 

//父类子类构造器
Base::Base(std::string xz){
	shape = xz;
	color = "red";
	count = 2;
	std::cout << "Init:\n" << shape << " - " << color << " - " << count << "\n"; 
};
//!注意这里的构造器的继承 
Sub::Sub(std::string xz):Base(xz){
	shape = "圆形"; 
	color = "yellow"; 
	//count  = 15; (基类私有的是不能更改的)，同访问控制权限级别只能修改同权限及更大的权的方法与属性 
	std::cout << "子类初始化：" << shape << " & " << color;
}

//父类子类定义方法 
void Base::modity(std::string xz,std::string ys, short num){
	shape = xz;
	color = ys;
	count = num;
	std::cout << shape << " - " << color << " - " << count << "\n\n"; 
}


int main(void){
	
	//案例1 
	Base squre("squre");
	std::cout << "Modity：\n"; 
	squre.shape = "zhengfangxing";
	//声明的对象在public访问控制下可以通过对象.属性/方法进行访问, 但是（protected/private则不能用此进行访问与修改） 
	std::cout << squre.shape << "\n"; 
	//但可以通过内部公共的方法进行更改私有与保护的属性与方法; 
	squre.modity("正方形","Blue",5);
	
	std::cout << "-------------------------------" << std::endl;
	
	//案例2：
	Sub circular("circular");
	//当继承的权限为protected时候不能通过 对象.属性 进行访问基类中的public属性方法 
 	//circular.shape = "Circular";
	 
	return 0;
}
