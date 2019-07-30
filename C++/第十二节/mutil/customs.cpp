#include "customs.h"
//函数实现
//功能：实现程序的初始化打印
void init(std::string na,unsigned short ag){
    std::cout << "---初始化程序---\n";
    std::cout << "我的名字：" << na << " , 我的年龄：" << ag << std::endl;
}

//类方法的实现
//功能：初始化公司名字和产品 打印出公司名字和产品
Base::Base(std::string com, std::string pro){
    std::cout << "Enter -> Base 构造器！\n";
    company = com;
    product = pro;
}
Base::~Base(){
    std::cout << "Enter -> Base 析构器！\n";
}
void Base::print(){
    std::cout << "公司名称：" << company  << " , 产品：" << product << "\n";
}
