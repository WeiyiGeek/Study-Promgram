#include <iostream>
/**
    Create Time:2018��12��9��15:03:12
    Author��WeiyiGeek
    FUNCTION:��ʾԤ����ָ��
**/

//���棺head.h  ->>> HEAD_H
#ifndef HEAD_H    //�ж��Ƿ����HEAD_H û�ж������ִ������Ķ��弰�����
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
