#include "two.h"
//主要是实现定义方法
int second(int o){
    std::cout << "second | two: " << TWO << " / 2 = " << o / 2 << "\n";
    return 2;
}
//类的析取器
Def::~Def(){
    std::cout << "---离开\n";
}

void Def::twoFun(){
    std::cout << "twoFun: " << name << " | Worker: " << worker << std::endl;
}
