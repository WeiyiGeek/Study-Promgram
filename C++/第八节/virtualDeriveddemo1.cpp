#include <iostream>
/** 探究析构器是不是虚函数 */

class ClxBase
{
public:
    //注意构造器与析构器不能设置抽象方法
    ClxBase(){}; //基类构造器是空函数
    virtual ~ClxBase(){};  //基类析构器是空函数
    virtual void doSomething()
    {
        std::cout << "1.Do something in class ClxBase!\n";  //父类
    }
};

class ClxDerived : public ClxBase
{
public:
    ClxDerived(){
    };
    ~ClxDerived(){
        std::cout << "3.Output 子类的析构器 进行销毁内存空间 \n";
    };
    void doSomething()
    {
        std::cout << "2.Do something in class ClxDerived!\n"; //衍生
    };
};

int main()
{
    //采用指针形式
    ClxBase *pTest = new ClxDerived;
    pTest -> doSomething();
    delete pTest;

    std::cout << "\n-------------- 分割线 ------------\n\n";

    //采用实例化对象的形式
    ClxDerived demo;
    demo.doSomething();

    return 0;
}
