#include "one.h"
//主要是实现定义方法
int first(int o){
    std::cout << "First | one: " << ONE << " / 2 = " << o / 2 << "\n";
    return 1;
}

//类的构造器
Def::Def(std::string name,std::string worker){
    std::cout << "---进入初始化\n";
    this->name = name;
    this->worker = worker;
}

void Def::oneFun(){
    std::cout << "oneFun: " << name << " | Worker: " << worker << std::endl;
}
