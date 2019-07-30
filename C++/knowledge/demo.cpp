#include <iostream>

using namespace std;

class Base
{
public:
    //���� f ����
	void f(int x)
	{
		cout << "Base::f(int) " << x << endl;
	}
	void f(float x)
	{
		cout << "Base::f(float) " << x << endl;
	}

    //���� g ���� ��Virtual��������Ҫ
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
	Derived d;   //�������ַ�ʽ���ǲ����ֶ�ȥ�������������ڴ棬�����ڵ��ý��ܺ��Զ�����
	Base *pb = &d; //��Base���͵�ָ��ָ������Ķ����ַ

	pb->f(42);     // Base::f(int) 42
	pb->f(3.14f);  // Base::f(float) 3.14
	pb->g();       // Derived::g(void)

	return 0;
}
