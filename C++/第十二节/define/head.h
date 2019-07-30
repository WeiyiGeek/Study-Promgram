#include <iostream>
/**
    Create Time:2018年12月9日15:03:12
    Author：WeiyiGeek
    FUNCTION:演示预处理指令
**/

//常规：head.h  ->>> HEAD_H
#ifndef HEAD_H    //判断是否定义过HEAD_H 没有定义过就执行下面的定义及其语句
#define HEAD_H
class Def{
public:
    Def(std::string name,std::string worker);
    ~Def();
    void oneFun();
    void twoFun();
protected:
    std::string name;
    std::string worker;
};
#endif
