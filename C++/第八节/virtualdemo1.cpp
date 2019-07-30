#include <iostream>
/** C++ 虚函数 不尝试使用 **/

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
	void play(){
		std::cout << name << "正在玩耍 - Have Play! \n"; 
	} 
}; 
class Dog:public Pet{
public:
	Dog(std::string xm);
	//想法是为了 覆盖 父类的方法 
	void eat(){
		std::cout << name << "正在吃骨头大宴 - Have Dinner！\n"; 
	}
	void sleep(){
		std::cout << name << "正在四脚朝天的睡觉 - Have Sleep！\n"; 
	} 
	void play(){
		std::cout << name << "正在和主人玩球 - Have Play! \n"; 
	} 
};
 
class Cat:public Pet{
public:
	Cat(std::string xm); 
	void eat(){ 
		std::cout << name << "正在吃小鱼儿 - Have Dinner！\n"; 
	}
	void sleep(){
		std::cout << name << "正在躺着的睡觉 - Have Sleep！\n"; 
	} 
	void play(){
		Pet::play(); 
		std::cout << name << "正在玩毛线球 - Have Play! \n"; 
	}
}; 

//子类构造器 
Dog::Dog(std::string xm):Pet(xm){	
}
Cat::Cat(std::string xm):Pet(xm){
} 


int main(void){
	//常规类的实例化使用 是没任何问题的（能正常的覆盖父类的方法） 
	Dog gg("旺财");
	gg.eat();
	gg.sleep();
	gg.play();
	
	std::cout << "\n\n";
	 
	//当使用new关键字来new一个类的对象时候，将发生意想不到的问题
	Pet *cat = new Cat("加菲猫");
	//由于这里使用的是指针则使用 -> 成员/方法 
	cat -> eat();  //优先选择了基类里面的方法，而不是子类里面的覆盖方法 
	cat -> sleep();
	cat -> play();
	delete cat; //一定要记住使用后删除内存块

	return 0;	
} 
