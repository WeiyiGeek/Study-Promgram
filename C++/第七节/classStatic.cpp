#include <iostream>
#include <string>
/** 类的 静态属性与方法 **/ 

class Pet{
public:
    Pet(std::string theName);
    ~Pet();

    static int getCount(); //静态方法 

protected:
    std::string name;

private:
    static int count; //静态属性 
};

class Dog : public Pet
{
public:
    Dog(std::string theName);
};

class Cat : public Pet
{
public:
    Cat(std::string theName);
};

//静态属性 可以直接利用 
int Pet::count = 0;         // 注意这一句：他起码做了两件事  （1）在内存在分配地址 （2）初始化类count的数值 
//基类的构造器与析构器 
Pet::Pet(std::string theName)
{
    name = theName;
    count++; //静态变量会记录每次count值的变化 
    std::cout << "宠物出生了,名字叫做: " << name << "\n";
}
Pet::~Pet()
{
    count--;
    std::cout << name << ":已经挂掉了\n";
}
int Pet::getCount()
{
    return count;  // 为了返回类中私有的count变量 所创建的方法 
}
//子类的构造器 
Dog::Dog(std::string theName) : Pet(theName){
}
Cat::Cat(std::string theName) : Pet(theName){
}

int main()
{
    Dog dog("小黄");
    Cat cat("小白");
								//静态方法 可以直接利用 
    std::cout << "\n已经诞生了" << Pet::getCount() << "只宠物!\n\n";
	//注意下面这个大括号->所包括代码块是有生存周期的作用 
	{
		Dog dog_2("Tom_黑");
        Cat cat_2("Jerry_黑");
        std::cout << "\n现在一共诞生了" << Pet::getCount() << "只宠物!\n\n";		
	}

    std::cout << "\n现在还剩下 " << Pet::getCount() << " 只宠物!\n\n";
    return 0;
}
