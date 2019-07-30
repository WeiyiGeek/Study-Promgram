#include <iostream>
/** C++ 抽象函数实现 **/
class Pet{
public:
    Pet(std::string xm);
    std::string name;
    virtual void play() = 0;  //声明纯虚函数（抽象方法）- 可以减少代码量，由于不需要在基类中进行定义该方法行为
};
class Cat:public Pet{
public:
    Cat(std::string xm);
    //猫的玩耍方法

    void play(){
        std::cout << name << "正在玩毛线球！！！\n";
    }
};
class Dog:public Pet{
public:
    Dog(std::string xm);
    //狗的玩耍方法
    void play(){
        std::cout << name << "正在和主人一起玩球！！！\n";
    }
};

//构造器
Pet::Pet(std::string xm){
    name = xm;
}
Cat::Cat(std::string xm):Pet(xm){
}
Dog::Dog(std::string xm):Pet(xm){
}

int main(void){
    //类实例化对象
    Cat mm("小猫猫");
    Pet *cPt = &mm;  //有点类似于直接 new 一个 Cat对象
    cPt -> play();
    delete cPt;  //同样删除内存空间地址

    //采用new / delete
    Pet *dPt = new Dog("旺财");
    dPt -> play();
    delete dPt;

    std::cout << "\n一天的工作完成\n";
    return 0;
}
