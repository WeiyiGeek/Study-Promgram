#include <iostream>
using namespace std;
class Base
{
public:
    //���า�ǻ��෽��
	virtual void f(float x)
	{
		cout << "Base::f(float) " << x << endl;
	}
    //��������������ǲ�һ�µ� �������Ƿ��� virtual �������� | ע���ⲻ������ ��
	void g(float x)
	{
		cout << "Base::g(float) " << x << endl;
	}
    //���������������һ��   ����û�� virtual ���ཫ������ | ע���ⲻ�Ǹ��� ��
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
    �����ء��ķ�����ν�����û���������������Ի�Ľ����
    ������ʾ���У�bp �� dp ָ��ͬһ��ַ������˵���н��Ӧ������ͬ�ģ�����ʵ����������
**/

int main(void)
{
	Derived d;  //ʵ����������� (�����ŵ�)
	Base *pb = &d; //��������ַ
	Derived *pd = &d; //��������ַ

	pb -> f(3.14f); // Derived::f(float) 3.14    //�������鷽��
	pd -> f(3.14f); // Derived::f(float) 3.14

	pb -> g(3.14f); // Base::g(float) 3.14              //���ȵ��ñ���ķ���
	pd -> g(3.14f); // Derived::g(int) 3 (surprise!)   //���� g ����������

	pb -> h(3.14f); // Base::h(float) 3.14 (surprise!)   //���ȵ��ñ���ķ���
	pd -> h(3.14f); // Derived::h(float) 3.14           //���� h ����������

	return 0;
}
