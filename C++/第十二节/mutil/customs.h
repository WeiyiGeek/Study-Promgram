/**
    fileName:customs.h
    Create:2018年12月9日11:06:49
    Author:WeiyiGeek
    function:Class & FUNCTION
    last editer time ：2018年12月9日11:08:08
**/
#include <iostream>

//全局变量
const std::string NAME = "WeiyiGeek";
const unsigned short AGE = 22;

//函数实现
void init(std::string na,unsigned short ag);


//类的声明
class Base{
public:
    Base(std::string com, std::string pro);
    ~Base();
    void print();
protected:
    std::string company;
    std::string product;
};


