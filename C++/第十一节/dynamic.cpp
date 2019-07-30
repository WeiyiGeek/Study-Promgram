#include <iostream>
#include <string>
/** 动态内存申请 ***/
class Base{
public:
    //记得使用虚方法
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
    //动态生成及重新利用
    Base *pb = new Base("Hello");
    pb->demo();
    std::cout << pb <<"\n\n";
    delete pb;
    pb = NULL;

   //指针变量重复利用
    pb = new Child("APPLE");
    pb->demo();
    std::cout << pb <<"\n\n";
    delete pb;
    pb = NULL;

    return 0;
}
