#include <iostream>
/**C++ 之 验证静态方法不能调用非静态的属性 */
class Base {
public:
	std::string name;
	int sex; 
	static int num;	
	//在类里面进行声明定义（也是可以的） 
	Base(std::string na,int sex){
		name = na;
		this->sex = sex; 
		std::cout << "我的名字：" << name << " this 地址："  << this << std::endl; 
	} 
	static void method(){
		std::cout << "静态方法调用静态属性：" <<Base::num << "\n"; 
		//std::cout << "静态方法调用非静态属性：" << name << "\n";  //会报错  [错误]在静态成员函数中的名称调用非静态成员
		//std::cout << this->name << " this 地址：" << this->num << "\n";  //不能在静态成员方法中使用 this 指针（因为根本不会传入对象） 
	} 
	void vitry(){
		std::cout <<  "类中第1个name成员地址：" << &this->name << " --- " << this->name << "\n";
		std::cout <<  "类中第2个sex成员地址：" << &this->sex << " --- " <<this->sex << "\n";
	}
};

//初始化静态属性
int Base::num = 1024; 

int main(void){
	//实例化对象
	
	Base myName("张军",1); 
	Base::method();  //### 注意：调用静态方法时候采用基类名之间调用即可 
	myName.method();  //虽然下面这种也能行,但是不建议使用对象名来调用静态成员方法 
	std::cout << "\n"; 
	std::cout << "对象的地址：" <<  &myName << std::endl; 
	myName.vitry();  //构造器中this地址与对象的地址相同 （且地址与类中第一个成员或者方法地址相同|类似于数组的地址一样） 
	
	return 0;
}
