#include <iostream>
#include <string>
/** ��̬�ڴ����� ***/
class Base{
public:
    //�ǵ�ʹ���鷽��
    Base(std::string na){
        name = na;
        std::cout << "Base name = " << name << std::endl;
    }
    virtual void demo(){
        std::cout << "This is Base() Demo " << std::endl;
    }
protected:
    std::string name;
};

class Child:public Base{
public:
    Child(std::string na):Base(na){
        std::cout << "Child Name = " << name << std::endl;
    }
    void demo(){
        std::cout << "This is Child() Demo " << std::endl;
    }
};

int main(void){
    //��̬���ɼ���������
    Base *pb = new Base("Hello");
    pb->demo();
    std::cout << pb <<"\n\n";
    delete pb;
    pb = NULL;

   //ָ������ظ�����
    pb = new Child("APPLE");
    pb->demo();
    std::cout << pb <<"\n\n";
    delete pb;
    pb = NULL;

    return 0;
}
