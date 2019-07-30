#include <iostream>
using namespace std;
class Base
{
public:
    //子类覆盖基类方法
	virtual void f(float x)
	{
		cout << "Base::f(float) " << x << endl;
	}
    //与子类参数类型是不一致的 （无论是否有 virtual 都将隐藏 | 注意这不是重载 ）
	void g(float x)
	{
		cout << "Base::g(float) " << x << endl;
	}
    //与子类参数类型是一致   （在没有 virtual 父类将被隐藏 | 注意这不是覆盖 ）
	void h(float x)
	{
		cout << "Base::h(float) " << x << endl;
	}
};

class Derived : public Base
{
public:
	virtual void f(float x)
	{
		cout << "Derived::f(float) " << x << endl;
	}

	void g(int x)
	{
		cout << "Derived::g(int) " << x << endl;
	}
	void h(float x)
	{
		cout << "Derived::h(float) " << x << endl;
	}
};
/**
    “隐藏”的发生可谓神出鬼没，常常产生令人迷惑的结果。
    如以下示例中，bp 和 dp 指向同一地址，按理说运行结果应该是相同的，可事实并非这样。
**/

int main(void)
{
	Derived d;  //实例化子类对象 (存在优点)
	Base *pb = &d; //子类对象地址
	Derived *pd = &d; //子类对象地址

	pb -> f(3.14f); // Derived::f(float) 3.14    //由于是虚方法
	pd -> f(3.14f); // Derived::f(float) 3.14

	pb -> g(3.14f); // Base::g(float) 3.14              //优先调用本类的方法
	pd -> g(3.14f); // Derived::g(int) 3 (surprise!)   //基类 g 方法被隐藏

	pb -> h(3.14f); // Base::h(float) 3.14 (surprise!)   //优先调用本类的方法
	pd -> h(3.14f); // Derived::h(float) 3.14           //基类 h 方法被隐藏

	return 0;
}
