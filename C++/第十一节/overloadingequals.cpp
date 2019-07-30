#include <iostream>
#include <string>
/** ���� = ���� ���ƶ��� **/

class MyClass
{
public:
    //������
    MyClass(int *p){
          ptr = p;
    }
    //��ȡ��
    ~MyClass(){
        delete ptr;
    }

    //���ظ�ֵ�������
    MyClass &operator=(const MyClass &rhs){
        // a = b;
    if( this != &rhs )
    {
        delete ptr;  //ʵ��ɾ����ָ��ָ��ĵ�ַ���ڴ��
        ptr = NULL;  //�����ָ��ָ��ĵ�ַ
        ptr = new int;
        *ptr = *rhs.ptr; //��������ptr��ָ�룬���� ��߶����ָ����
    }
    else
    {
        std::cout << "��ֵ������Ϊͬ�����󣬲�������\n"; // obj1 = obj1;
    }
        return *this;  //���ض���
    }

    void print(){
        std::cout << this << "  |  " << *ptr << std::endl;
    }
private:
    int *ptr;  //����һ��ָ��
};

int main()
{
    MyClass obj1(new int(1024));
    MyClass obj2(new int(512));

    obj1.print();
    obj2.print();

    obj2 = obj1;  //��obj1 �����ַ ��Ÿ� ����obj2��ָ���� �����أ�

    obj1.print();
    obj2.print();

    return 0;
}
