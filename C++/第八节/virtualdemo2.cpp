#include <iostream>
/** C++ new 对象 => 尝试使用虚函数 进行覆盖基类中的方法  **/

class Pet{
public:
	std::string name;
	//基类构造器方法 
	Pet(std::string xm){
		name = xm;
		std::cout << "姓名初始化：" << name << "\n";
	}
	void eat(){
		std::cout << name << "正在吃饭 - Have Dinner！\n"; 
	} 
	void sleep(){
		std::cout << name << "正在睡觉 - Have Sleep！\n"; 
	} 
	//声明定义为虚方法 
	virtual	void play(){
		std::cout << name << "正在玩耍 - Have Play! \n"; 
	} 
}; 
 
class Cat:public Pet{
public:
	Cat(std::string xm); 
	void eat(){ 
		std::cout << name << "正在吃小鱼儿 - Have Dinner！\n"; 
	}
	void sleep(){
		Pet::sleep(); //由于不是虚方法，子类中sleep()无法覆盖 基类的sleep()方法 （下面的语句将不被执行） 
		std::cout << name << "正在躺着的睡觉 - Have Sleep！\n"; 
	} 
	void play(){
		//Pet::play(); 由于是虚方法将会输出这个方法（同时也会输出下面的语句） 
		std::cout << name << "正在玩毛线球 - Have Play! \n"; 
	}
}; 

//子类构造器 
Cat::Cat(std::string xm):Pet(xm){
} 


int main(void){
	//定义一个Pet类型的cat指针变量 存放 的是一个new出来对象的地址; （指针及地址） 
	Pet *cat = new Cat("加菲猫");
	//由于这里使用的是指针则使用 -> 成员/方法 
	cat -> eat();  
	cat -> sleep();
	cat -> play();
	delete cat; //一定要记住使用后删除内存块
	return 0;	
} 
