#include <iostream>

using namespace std;

class Base
{
public:
    //重载 f 函数
	void f(int x)
	{
		cout << "Base::f(int) " << x << endl;
	}
	void f(float x)
	{
		cout << "Base::f(float) " << x << endl;
	}

    //覆盖 g 函数 （Virtual）至关重要
	virtual void g(void)
	{
		cout << "Base::g(void)" << endl;
	}
};

class Derived : public Base
{
public:
	virtual void g(void)
	{
		cout << "Derived::g(void)" << endl;
	}
};

int main(void)
{
	Derived d;   //采用这种方式我们不用手动去清理我们申请内存，程序在调用介绍后自动清理
	Base *pb = &d; //将Base类型的指针指向子类的对象地址

	pb->f(42);     // Base::f(int) 42
	pb->f(3.14f);  // Base::f(float) 3.14
	pb->g();       // Derived::g(void)

	return 0;
}
